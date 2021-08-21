package net.devtech.grossfabrichacks;

import net.devtech.grossfabrichacks.entrypoints.TransformerRegistrar;
import net.devtech.grossfabrichacks.instrumentation.InstrumentationApi;
import net.devtech.grossfabrichacks.transformer.TransformerApi;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;

import java.util.Random;

public class MasmMain implements TransformerRegistrar {
    @Override
    public void registerTransformers() {
        System.out.println("Hello world");
        TransformerApi.registerPostMixinAsmClassTransformer((name, node) -> {
            System.out.println(name);
        });
    
        InstrumentationApi.retransform(Random.class, (name, node) -> {
            node.methods.forEach(methodNode -> {
                if (methodNode.name.equals("next")) {
                    methodNode.instructions.clear();
                    methodNode.instructions.add(new LdcInsnNode(4));
                    methodNode.instructions.add(new InsnNode(Opcodes.IRETURN));
                }
            });
        });
        
        System.out.println(new Random().nextInt());
        System.out.println(new Random().nextInt());
        System.out.println(new Random().nextInt());
    }
}
