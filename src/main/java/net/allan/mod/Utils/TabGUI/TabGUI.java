package net.allan.mod.Utils.TabGUI;

import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Events.EventKeyboardOnKey;
import net.allan.mod.Utils.EventManager.Core.EventPriority;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.allan.mod.Utils.ModuleManager.ModuleManager;
import net.allan.mod.Utils.Renderer2D.Renderer2D;
import org.lwjgl.glfw.GLFW;

import java.awt.*;

public class TabGUI {

    public static boolean bOpen = true;

    public static float iPosX = 7.5f;
    public static float iPosY = 7.5f;

    private int iCurrentTab = 0;

    public static void toggleOpen() {
        bOpen = !bOpen;
    }

    @IListenableMethod(bPriority = EventPriority.LOWEST)
    public void render(EventInGameHudRender e) {

        if (!bOpen)
            return;

        final var moduleTypes = ModuleManager.mModules.keySet();

        Renderer2D.drawText(iPosX, iPosY, new Color(255, 195, 0, 255), "allan-mod");
        Renderer2D.drawRectFilled(iPosX, iPosY + 15.f, 60.f, 12.f * moduleTypes.size() + 2.5f + 2.5f, new Color(40, 40, 40, 255));

        int count = 0;
        for (final var cat : moduleTypes) {
            Renderer2D.drawText(iPosX + 5.f, iPosY + 15.f + 2.f + (count * 12.f) + 2.5f, count == iCurrentTab ? new Color(255, 255, 255, 255) : new Color(150, 150, 150, 255), cat.toString());
            count++;
        }
    }

    @IListenableMethod()
    public void onKey(EventKeyboardOnKey e) {

        if (e.iKey == GLFW.GLFW_KEY_UP && e.iAction == 1) {

            if (iCurrentTab <= 0)
                iCurrentTab = ModuleManager.mModules.keySet().size() - 1;
            else
                iCurrentTab--;
        }
        else if (e.iKey == GLFW.GLFW_KEY_DOWN && e.iAction == 1) {

            if (iCurrentTab >= ModuleManager.mModules.keySet().size() - 1)
                iCurrentTab = 0;
            else
                iCurrentTab++;
        }
    }
}
