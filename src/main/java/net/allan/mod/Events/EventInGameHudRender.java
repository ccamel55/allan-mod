package net.allan.mod.Events;

import net.allan.mod.Utils.EventManager.Interfaces.EventCancellable;
import net.minecraft.client.util.math.MatrixStack;

public class EventInGameHudRender extends EventCancellable {

    public MatrixStack mMatrixStack;

    public EventInGameHudRender(MatrixStack matrixStack) {
        mMatrixStack = matrixStack;
    }
}
