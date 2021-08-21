package org.spongepowered.asm.mixin.transformer;

import com.github.p03w.masm.MassASM;
import com.github.p03w.masm.unsafe.UnsafeUtil;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;

import java.lang.reflect.Field;

public class HackedMixinTransformer extends MixinTransformer {
    public static final Class<MixinTransformer> superclass = MixinTransformer.class;

    public static final HackedMixinTransformer instance;
    public static final MixinProcessor processor;
    public static final Extensions extensions;

    @Override
    public byte[] transformClass(final MixinEnvironment environment, final String name, byte[] classBytes) {
        // ASM patching
        return this.transform(environment, this.readClass(classBytes), classBytes);
    }

    public byte[] transform(MixinEnvironment environment, ClassNode classNode, byte[] original) {
        final String name = classNode.name;

        // return immediately to reduce jumps and assignments
        if (MassASM.State.shouldWrite) {
            if (MassASM.State.transformPreMixinAsmClass) {
                MassASM.State.preMixinAsmClassTransformer.transform(name, classNode);
            }

            processor.applyMixins(environment, name.replace('/', '.'), classNode);

            if (MassASM.State.transformPostMixinAsmClass) {
                MassASM.State.postMixinAsmClassTransformer.transform(name, classNode);
            }

            return this.writeClass(classNode);
        }

        if (processor.applyMixins(environment, name.replace('/', '.'), classNode)) {
            return this.writeClass(classNode);
        }

        return original;
    }

    static {
        try {
            final Object mixinTransformer = MixinEnvironment.getCurrentEnvironment().getActiveTransformer();

            // here, we modify the klass pointer in the object to point towards the HackedMixinTransformer class, effectively turning the existing
            // MixinTransformer instance into an instance of HackedMixinTransformer
            UnsafeUtil.unsafeCast(mixinTransformer, "org.spongepowered.asm.mixin.transformer.HackedMixinTransformer");

            instance = (HackedMixinTransformer) mixinTransformer;
            
            Field processorField = Class.forName("org.spongepowered.asm.mixin.transformer.MixinTransformer").getDeclaredField("processor");
            processorField.setAccessible(true);
            processor = (MixinProcessor) processorField.get(mixinTransformer);
    
    
            Field extensionsField = superclass.getDeclaredField("extensions");
            extensionsField.setAccessible(true);
            extensions = (Extensions) extensionsField.get(mixinTransformer);
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
