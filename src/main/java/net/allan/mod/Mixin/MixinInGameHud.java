package net.allan.mod.Mixin;

import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Utils.EventManager.EventManager;
import net.allan.mod.Utils.Renderer2D.Renderer2D;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {

    @Inject(method = "render", at = @At("TAIL"), cancellable = true)
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        Renderer2D.begin(matrices);
        EventManager.call(new EventInGameHudRender(matrices));
        Renderer2D.finish();
    }
}
