package net.allan.mod.Utils.CommandManager.Core;

import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;
import net.allan.mod.Utils.ConfigManager.ConfigManager;

public class CommandConfig extends ModCommand {

    public CommandConfig() {
        super("Used to load or save the mod config", "<save|load>");
    }

    @Override
    public void handleMessage(String[] message) {
        if (message[1].equals("save")) {
            if (!ConfigManager.save()){
                ChatMessage.printChatMessage("Error saving settings");
                return;
            }

            ChatMessage.printChatMessage("Saved settings");
        }
        else if (message[1].equals("load")) {
            if (!ConfigManager.load()){
                ChatMessage.printChatMessage("Error loading settings");
                return;
            }

            ChatMessage.printChatMessage("Loaded settings");
        }
        else
            ChatMessage.printChatMessage("Its 'save' or 'load' u dickhead not '" + message[1] + "'");
    }

    @Override
    public boolean checkSyntax(String[] message) {
        return message.length == 2;
    }
}
