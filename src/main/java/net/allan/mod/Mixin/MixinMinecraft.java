package net.allan.mod.Mixin;

import net.allan.mod.Events.EventMinecraftTickPre;
import net.allan.mod.Utils.EventManager.EventManager;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraft {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tickPre(CallbackInfo ci) {
        EventManager.call(new EventMinecraftTickPre());
    }
}
