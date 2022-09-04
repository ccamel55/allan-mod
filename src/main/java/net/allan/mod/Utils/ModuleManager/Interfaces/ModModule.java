package net.allan.mod.Utils.ModuleManager.Interfaces;

import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;

public abstract class ModModule {
    public String sName;
    public String sCommandName;

    public int iToggleKey;
    public boolean bEnabled;
    public boolean bIsCheat;

    public ModCommand pCommand;
    public ModuleProperties pProperties;

    public void toggleEnable() {
        bEnabled = !bEnabled;
        onToggle(bEnabled);
    }

    // called once everytime we change the setting
    public abstract void onToggle(boolean val);
}
