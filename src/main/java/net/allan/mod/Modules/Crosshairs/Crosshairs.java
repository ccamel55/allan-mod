package net.allan.mod.Modules.Crosshairs;

import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class Crosshairs extends ModModule {

    public Crosshairs() {
        sName = "Crosshair";
        sCommandName = "xhair";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }
}
