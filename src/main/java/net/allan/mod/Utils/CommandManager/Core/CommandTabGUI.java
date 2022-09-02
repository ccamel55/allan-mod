package net.allan.mod.Utils.CommandManager.Core;

import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;
import net.allan.mod.Utils.TabGUI.TabGUI;

public class CommandTabGUI extends ModCommand {

    public CommandTabGUI() {
        super("Toggles the tab GUI", "EMPTY");
    }

    @Override
    public void handleMessage(String[] message) {

        TabGUI.toggleOpen();
        ChatMessage.printChatMessage("Toggled Tab GUI");
    }

    @Override
    public boolean checkSyntax(String[] message) {
        return message.length == 1;
    }
}
