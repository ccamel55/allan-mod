package net.allan.mod.Utils.CommandManager.Core;

import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;

public class CommandBind extends ModCommand {

    public CommandBind() {
        super("Bind a key to toggle a module", "<Module> <Key>");
    }

    @Override
    public void handleMessage(String[] message) {
        ChatMessage.printChatMessage("NEED TO DO STILL!!!");
    }

    @Override
    public boolean checkSyntax(String[] message) {
        return message.length == 3;
    }
}
