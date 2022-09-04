package net.allan.mod.Modules.Fullbright;

import net.allan.mod.AllanMod;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class Fullbright extends ModModule {

    public Fullbright() {
        sName = "Fullbright";
        sCommandName = "fbright";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }

    @Override
    public void onToggle(boolean val) {
        AllanMod.client.options.getGamma().setValue(val ? 1.0 : 0.0);
    }
}
