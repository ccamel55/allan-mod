package net.allan.mod.Modules.Keystrokes;

import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class Keystrokes extends ModModule {

    public Keystrokes() {
        sName = "Keystrokes";
        sCommandName = "kstrokes";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }
}
