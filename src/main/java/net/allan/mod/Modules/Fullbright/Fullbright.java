package net.allan.mod.Modules.Fullbright;

import net.allan.mod.AllanMod;
import net.allan.mod.Events.EventMinecraftTickPre;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.allan.mod.Utils.GameOptionsManager.GameOptionsManager;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class Fullbright extends ModModule {

    private boolean bInitGameOption;

    private double dDefaultGamma = 0.0;
    public final double dFullbrightGamma = 69420.0;

    public Fullbright() {
        sName = "Fullbright";
        sCommandName = "fbright";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }

    @IListenableMethod
    public void onTick(EventMinecraftTickPre e) {

        final var gameOptions = AllanMod.client.options;

        if (gameOptions == null)
            return;

        final var curGamma = gameOptions.getGamma().getValue();

        // add to constraint ignore
        if (!bInitGameOption) {
            GameOptionsManager.addIgnoreCheck(gameOptions.getGamma());
            dDefaultGamma = curGamma;
            bInitGameOption = true;
        }

        if (bEnabled) {
            if (curGamma != dFullbrightGamma)
                gameOptions.getGamma().setValue(dFullbrightGamma);
        }
        else {
            if (curGamma != dDefaultGamma)
                gameOptions.getGamma().setValue(dDefaultGamma);
        }
    }
}
