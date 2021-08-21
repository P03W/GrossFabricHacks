package net.devtech.grossfabrichacks;

import net.devtech.grossfabrichacks.entrypoints.TransformerRegistrar;
import net.devtech.grossfabrichacks.transformer.TransformerApi;

public class MasmMain implements TransformerRegistrar {
    @Override
    public void registerTransformers() {
        System.out.println("Hello world");
        TransformerApi.registerPostMixinAsmClassTransformer((name, node) -> {
            System.out.println(name);
            System.out.println(node);
        });
    }
}
