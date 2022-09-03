package net.allan.mod.Mixin;

import net.allan.mod.Utils.CommandManager.CommandManager;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayerEntity {

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    public void sendChatMessage(String message, @Nullable Text preview, CallbackInfo ci) {
        if (message.charAt(0) == CommandManager.commandPrefix) {
            CommandManager.onSendMessage(message);
            ci.cancel();
        }
    }
}
