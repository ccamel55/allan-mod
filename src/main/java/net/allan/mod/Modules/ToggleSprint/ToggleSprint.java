package net.allan.mod.Modules.ToggleSprint;

import net.allan.mod.AllanMod;
import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Events.EventMinecraftTickPre;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;
import net.allan.mod.Utils.Renderer2D.Renderer2D;

import java.awt.*;

public class ToggleSprint extends ModModule {

    public ToggleSprint() {
        sName = "Toggle Sprint";
        sCommandName = "tsprint";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }

    @IListenableMethod
    public void onTick(EventMinecraftTickPre e) {

        final var gameOptions = AllanMod.client.options;

        if (!bEnabled || gameOptions == null)
            return;

        if (gameOptions.sneakKey.wasPressed()) {
            if (gameOptions.getSneakToggled().getValue()) {
                gameOptions.getSneakToggled().setValue(false);
            }
            else
                gameOptions.getSneakToggled().setValue(true);
        }

        if (gameOptions.sprintKey.wasPressed()) {
            if (gameOptions.getSprintToggled().getValue()) {
                gameOptions.getSprintToggled().setValue(false);
            }
            else
                gameOptions.getSprintToggled().setValue(true);
        }
    }

    @IListenableMethod
    public void onRender(EventInGameHudRender e) {

        final var gameOptions = AllanMod.client.options;

        if (!bEnabled || gameOptions == null)
            return;

        final var isSprint = gameOptions.getSprintToggled().getValue();
        final var isSneak = gameOptions.getSneakToggled().getValue();

        if (isSneak || isSprint)
            Renderer2D.drawText(AllanMod.client.getWindow().getScaledWidth() / 2, 20, new Color(255, 255, 255, 255), isSneak ? "[sneaky]" : "[run lol]");
    }
}
