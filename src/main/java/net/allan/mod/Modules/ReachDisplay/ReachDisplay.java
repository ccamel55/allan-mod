package net.allan.mod.Modules.ReachDisplay;

import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class ReachDisplay extends ModModule {

    public ReachDisplay() {
        sName = "Reach Display";
        sCommandName = "rdisp";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }
}
