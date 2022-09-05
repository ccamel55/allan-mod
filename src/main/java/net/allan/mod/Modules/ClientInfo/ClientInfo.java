package net.allan.mod.Modules.ClientInfo;

import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

public class ClientInfo extends ModModule {

    public ClientInfo() {
        sName = "Client Info";
        sCommandName = "cinfo";

        iToggleKey = -1;
        bEnabled = false;
        bIsCheat = false;

        pCommand = null;
        pProperties = null;
    }
}
