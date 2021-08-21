package com.github.p03w.masm.mixin;

import com.github.p03w.masm.MassASM;
import com.github.p03w.masm.entrypoints.TransformerRegistrar;
import com.github.p03w.masm.transformer.TransformerApi;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import user11681.dynamicentry.DynamicEntry;

import java.util.List;
import java.util.Set;

public class MassASMPlugin implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {}
    
    @Override
    public String getRefMapperConfig() {
        return null;
    }
    
    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }
    
    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    
    @Override
    public List<String> getMixins() {
        return null;
    }
    
    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    
    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    
    static {
        MassASM.State.mixinLoaded = true;
    
        DynamicEntry.execute("masm:register", TransformerRegistrar.class, TransformerRegistrar::registerTransformers);
        
        if (MassASM.State.shouldWrite || MassASM.State.manualLoad) {
            TransformerApi.manualLoad();
        }
    }
}
