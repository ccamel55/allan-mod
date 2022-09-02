package net.allan.mod.Utils.TabGUI;

import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Utils.EventManager.Core.EventPriority;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.minecraft.client.gui.DrawableHelper;

public class TabGUI {

    public static boolean bOpen = true;

    public static void toggleOpen() {
        bOpen = !bOpen;
    }

    @IListenableMethod(bPriority = EventPriority.LOWEST)
    public void render(EventInGameHudRender e) {

        if (!bOpen)
            return;

        DrawableHelper.fill(e.mMatrixStack,10, 10, 20, 20, 0xFFFFFFFF);
    }
}
