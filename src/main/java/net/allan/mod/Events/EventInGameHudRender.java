package net.allan.mod.Events;

import net.allan.mod.Utils.EventManager.Interfaces.IEvent;
import net.minecraft.client.util.math.MatrixStack;

public class EventInGameHudRender implements IEvent {

    public MatrixStack mMatrixStack;

    public EventInGameHudRender(MatrixStack matrixStack) {
        mMatrixStack = matrixStack;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
