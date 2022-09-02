package net.allan.mod.Utils.CommandManager.Interfaces;

public abstract class ModCommand {

    public String sDescription;
    public String sSyntax;

    public ModCommand(String desc, String syntax) {
        sDescription = desc;
        sSyntax = syntax;
    }

    public abstract void handleMessage(String[] message);
    public abstract boolean checkSyntax(String[] message);
}
