package net.allan.mod.Modules.TntTimer;

import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class TntTimer extends ModModule {

    public TntTimer() {
        sName = "Tnt Timer";
        sCommandName = "tnttimer";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }
}
