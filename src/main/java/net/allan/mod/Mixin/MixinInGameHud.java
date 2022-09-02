package net.allan.mod.Mixin;

import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Utils.EventManager.EventManager;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {

        EventManager.call(new EventInGameHudRender(matrices));
    }
}
