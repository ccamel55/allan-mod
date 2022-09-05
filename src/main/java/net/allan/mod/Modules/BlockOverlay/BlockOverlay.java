package net.allan.mod.Modules.BlockOverlay;

import net.allan.mod.AllanMod;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class BlockOverlay extends ModModule {

    public BlockOverlay() {
        sName = "Block Outline";
        sCommandName = "boutline";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }
}
