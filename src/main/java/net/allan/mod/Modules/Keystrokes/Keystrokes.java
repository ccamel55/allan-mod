package net.allan.mod.Modules.Keystrokes;

import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class Keystrokes extends ModModule {

    public static class CommandKeyStrokes extends ModCommand {

        public CommandKeyStrokes() {
            super("Keystrokes mod", "<cps|space>");
        }

        @Override
        public void handleMessage(String[] message) {

        }

        @Override
        public boolean checkSyntax(String[] message) {
            return message.length == 2;
        }
    }

    public Keystrokes() {

        sName = "Keystrokes ";
        sCommandName = "keystrokes";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = new CommandKeyStrokes();
    }

    @IListenableMethod()
    public void render(EventInGameHudRender e) {

    }
}
