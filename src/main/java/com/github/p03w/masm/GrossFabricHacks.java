package com.github.p03w.masm;

import com.github.p03w.masm.transformer.AsmClassTransformer;
import com.github.p03w.masm.unsafe.UnsafeUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.LanguageAdapter;

import java.io.InputStream;

public class GrossFabricHacks implements LanguageAdapter {
    @Override
    public native <T> T create(net.fabricmc.loader.api.ModContainer mod, String value, Class<T> type);

    public static class State {
        public static boolean mixinLoaded;
        public static boolean manualLoad;

        public static boolean shouldWrite;
        public static boolean transformPreMixinAsmClass;
        public static boolean transformPostMixinAsmClass;
        public static AsmClassTransformer preMixinAsmClassTransformer;
        public static AsmClassTransformer postMixinAsmClassTransformer;
    }

    static {
        try {
            final ClassLoader applicationClassLoader = FabricLoader.class.getClassLoader();
            final ClassLoader KnotClassLoader = GrossFabricHacks.class.getClassLoader();

            final String[] classes = {
                "net.gudenau.lib.unsafe.Unsafe",
                "net.devtech.grossfabrichacks.GrossFabricHacks$State",
                "net.devtech.grossfabrichacks.unsafe.UnsafeUtil",
                "net.devtech.grossfabrichacks.unsafe.UnsafeUtil$FirstInt"
            };

            final int classCount = classes.length;

            for (int i = FabricLoader.getInstance().isDevelopmentEnvironment() ? 1 : 0; i < classCount; i++) {
                final String name = classes[i];
                final InputStream classStream = KnotClassLoader.getResourceAsStream(name.replace('.', '/') + ".class");
                assert classStream != null;
                final byte[] bytecode = new byte[classStream.available()];
    
                //noinspection StatementWithEmptyBody
                while (classStream.read(bytecode) != -1) {}

                UnsafeUtil.defineClass(name, bytecode, applicationClassLoader, GrossFabricHacks.class.getProtectionDomain());
            }
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
