package net.allan.mod.Mixin;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SplashTextResourceSupplier.class)
public class MixinSplashTextResource {

    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private void get(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue("what?");
    }
}
