package net.allan.mod.Utils.CommandManager.Core;

import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.CommandManager;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;

public class CommandHelp extends ModCommand {

    public CommandHelp() {
        super("Returns the description and syntax of a command", "<Command>");
    }

    @Override
    public void handleMessage(String[] message) {
        // user probably just typed help because they are used to it so show all basic commands
        if (message.length == 1) {
            ChatMessage.printChatMessage("type '.help all' to print out all commands, '.help modules' to show all modules");
            return;
        }

        // print out all the commands and their "help" message
        if (message[1].equals("all")) {
            StringBuilder chatPrint = new StringBuilder();

            for (final var cmdKey : CommandManager.mCommands.keySet()) {
                final var cmd = CommandManager.mCommands.get(cmdKey);
                chatPrint.append("\n\u00A77").append(cmdKey).append(": ").append(cmd.sDescription).append(" | \u00A7e").append(cmd.sSyntax);
            }

            ChatMessage.printChatMessage(chatPrint.toString());
        }
        else if (message[1].equals("modules")) {
            StringBuilder chatPrint = new StringBuilder();

            for (final var cmdKey : CommandManager.mModuleCmdName.keySet())
                chatPrint.append("\n\u00A77").append(cmdKey);

            ChatMessage.printChatMessage(chatPrint.toString());
        }
        else if (CommandManager.mModuleCmdName.containsKey(message[1])) {
            // utter shithousery right here
            final var module = CommandManager.mModuleCmdName.get(message[1]);
            ChatMessage.printChatMessage("\n\u00A77" + message[1] + ": " + module.pCommand.sDescription + " | \u00A7e"+ module.pCommand.sSyntax);
        }
        else
            ChatMessage.printChatMessage("Could not find module: '" + message[1] + "'");
    }

    @Override
    public boolean checkSyntax(String[] message) {
        return message.length <= 2;
    }
}
