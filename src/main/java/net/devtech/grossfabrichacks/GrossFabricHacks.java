package net.devtech.grossfabrichacks;

import net.devtech.grossfabrichacks.entrypoints.TransformerRegistrar;
import net.devtech.grossfabrichacks.transformer.asm.AsmClassTransformer;
import net.devtech.grossfabrichacks.transformer.asm.RawClassTransformer;
import net.devtech.grossfabrichacks.unsafe.UnsafeUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.LanguageAdapter;
import net.fabricmc.loader.launch.knot.UnsafeKnotClassLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import user11681.dynamicentry.DynamicEntry;

import java.io.InputStream;

public class GrossFabricHacks implements LanguageAdapter {
    private static final Logger LOGGER = LogManager.getLogger("GrossFabricHacks");

    public static final UnsafeKnotClassLoader UNSAFE_LOADER;

    @Override
    public native <T> T create(net.fabricmc.loader.api.ModContainer mod, String value, Class<T> type);

    public static class State {
        public static boolean mixinLoaded;
        public static boolean manualLoad;

        public static boolean shouldWrite;
        // micro-optimization: cache transformer presence
        public static boolean transformPreMixinRawClass;
        public static boolean transformPreMixinAsmClass;
        public static boolean transformPostMixinRawClass;
        public static boolean transformPostMixinAsmClass;
        public static RawClassTransformer preMixinRawClassTransformer;
        public static RawClassTransformer postMixinRawClassTransformer;
        public static AsmClassTransformer preMixinAsmClassTransformer;
        public static AsmClassTransformer postMixinAsmClassTransformer;
    }

    static {
        LOGGER.info("no good? no, this man is definitely up to evil.");

        try {
            final ClassLoader applicationClassLoader = FabricLoader.class.getClassLoader();
            final ClassLoader KnotClassLoader = GrossFabricHacks.class.getClassLoader();

            final String[] classes = {
                "net.gudenau.lib.unsafe.Unsafe",
                "net.devtech.grossfabrichacks.instrumentation.InstrumentationAgent",
                "net.devtech.grossfabrichacks.instrumentation.InstrumentationApi",
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

            LOGGER.warn("KnotClassLoader, you fool! Loading me was a grave mistake.");
            
            UNSAFE_LOADER = UnsafeUtil.defineAndInitializeAndUnsafeCast(KnotClassLoader, "net.fabricmc.loader.launch.knot.UnsafeKnotClassLoader", KnotClassLoader.getClass().getClassLoader());
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
