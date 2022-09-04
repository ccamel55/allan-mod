package net.allan.mod.Utils.CommandManager.Core;

import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.CommandManager;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;

public class CommandToggle extends ModCommand {

    public CommandToggle() {
        super("Toggle a module on/off", "<Command>");
    }

    @Override
    public void handleMessage(String[] message) {
        if (!CommandManager.mModuleCmdName.containsKey(message[1])) {
            ChatMessage.printChatMessage("Could not find module: '" + message[1] + "'");
            return;
        }

        // ha
        final var module = CommandManager.mModuleCmdName.get(message[1]);
        module.toggleEnable();

        ChatMessage.printChatMessage(message[1] + " is now " + (module.bEnabled ? "\u00A7aenabled" : "\u00A7cdisabled"));
    }

    @Override
    public boolean checkSyntax(String[] message) {
        return message.length == 2;
    }
}
