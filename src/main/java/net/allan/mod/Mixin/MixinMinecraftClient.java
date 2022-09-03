package net.allan.mod.Mixin;

import net.allan.mod.AllanMod;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "updateWindowTitle", at = @At("HEAD"), cancellable = true)
    public void updateWindowTitle(CallbackInfo ci) {
        // update to our own then fuck off!!!
        AllanMod.client.getWindow().setTitle("allan-mod");
        ci.cancel();
    }
}
