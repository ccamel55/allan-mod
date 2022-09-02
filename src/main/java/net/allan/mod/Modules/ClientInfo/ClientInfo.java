package net.allan.mod.Modules.ClientInfo;

import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class ClientInfo extends ModModule {

    public static class CommandClientInfo extends ModCommand {

        public CommandClientInfo() {
            super("Displays client information that might be helpful", "<fps|ping|coords>");
        }

        @Override
        public void handleMessage(String[] message) {

        }

        @Override
        public boolean checkSyntax(String[] message) {
            return message.length == 2;
        }
    }

    public ClientInfo() {

        sName = "Client Info";
        sCommandName = "cinfo";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = new CommandClientInfo();
    }

    @IListenableMethod()
    public void render(EventInGameHudRender e) {

    }
}
