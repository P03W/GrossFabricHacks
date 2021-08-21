package com.github.p03w.masm.transformer;

import com.github.p03w.masm.MassASM;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.HackedMixinTransformer;

/**
 * The API class for getting access to transforming any and all classes loaded by the KnotClassLoader (or whatever classloader happens to call mixin)
 */
public class TransformerApi {
	/**
	 * manually load the class, causing it to inject itself into the class loading pipe.
	 */
	public static void manualLoad() {
		if (MassASM.State.mixinLoaded) {
			try {
				Class.forName("org.spongepowered.asm.mixin.transformer.HackedMixinTransformer");
			} catch (final ClassNotFoundException exception) {
				throw new RuntimeException(exception);
			}
		} else {
			MassASM.State.manualLoad = true;
		}
	}

	/**
	 * transformers are called before mixin application with the class' classnode
	 */
	public static void registerPreMixinAsmClassTransformer(AsmClassTransformer transformer) {
		if (MassASM.State.preMixinAsmClassTransformer == null) {
			MassASM.State.preMixinAsmClassTransformer = transformer;
			MassASM.State.transformPreMixinAsmClass = true;
			MassASM.State.shouldWrite = true;
		} else {
			MassASM.State.preMixinAsmClassTransformer = MassASM.State.preMixinAsmClassTransformer.andThen(transformer);
		}
	}

	/**
	 * transformer is called right after mixin application.
	 */
	public static void registerPostMixinAsmClassTransformer(AsmClassTransformer transformer) {
		if (MassASM.State.postMixinAsmClassTransformer == null) {
			MassASM.State.postMixinAsmClassTransformer = transformer;
			MassASM.State.transformPostMixinAsmClass = true;
			MassASM.State.shouldWrite = true;
		} else {
			MassASM.State.postMixinAsmClassTransformer = MassASM.State.postMixinAsmClassTransformer.andThen(transformer);
		}
	}

	public static byte[] transformClass(final ClassNode node) {
		return HackedMixinTransformer.instance.transform(MixinEnvironment.getCurrentEnvironment(), node, null);
	}

	static {
		manualLoad();
	}
}
