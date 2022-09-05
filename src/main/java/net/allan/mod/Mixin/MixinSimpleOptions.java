package net.allan.mod.Mixin;

import net.allan.mod.AllanMod;
import net.allan.mod.Utils.GameOptionsManager.GameOptionsManager;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(SimpleOption.class)
public class MixinSimpleOptions<T> {

    @Shadow
    private T value;

    @Shadow @Final
    private Consumer<T> changeCallback;

    @Inject(method = "setValue", at = @At("HEAD"), cancellable = true)
    public void setValue(T object, CallbackInfo ci) {
        final var thisSimpleOption = (SimpleOption<?>)(Object)this;

        if (GameOptionsManager.mIgnoreCheck.containsKey(thisSimpleOption)) {
            if (GameOptionsManager.mIgnoreCheck.get(thisSimpleOption)) {
                value = object;
                changeCallback.accept(this.value);

                ci.cancel();
            }
        }
    }
}
