package net.allan.mod.Utils.CommandManager;

import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.Core.CommandBind;
import net.allan.mod.Utils.CommandManager.Core.CommandHelp;
import net.allan.mod.Utils.CommandManager.Core.CommandTabGUI;
import net.allan.mod.Utils.CommandManager.Core.CommandToggle;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    //the rest of all our commands belong in a hash map
    public static Map<String, ModCommand> mCommands = new HashMap<>();
    public static Map<String, ModModule> mModuleCmdName = new HashMap<>();

    public static void init() {

        // we have 3 basic build int commands, help, bind and toggle
        mCommands.put(".help", new CommandHelp());
        mCommands.put(".bind", new CommandBind());
        mCommands.put(".toggle", new CommandToggle());
        mCommands.put(".gui", new CommandTabGUI());
    }

    public static void onSendMessage(String message) {

        final var messageSplit = message.split(" ");

        // not a valid command so BYE!!!
        if (messageSplit.length <= 0 || !mCommands.containsKey(messageSplit[0])) {
            ChatMessage.printChatMessage("command: '" + message + "' could not be found");
            return;
        }

        final var command = mCommands.get(messageSplit[0]);

        if (!command.checkSyntax(messageSplit)) {
            ChatMessage.printChatMessage("wrong syntax for: '" + messageSplit[0] + "', correct syntax: \u00A7e" + command.sSyntax);
            return;
        }

        command.handleMessage(messageSplit);
    }

    public static void addModule(ModModule module) {

        if (mModuleCmdName.containsKey(module.sCommandName))
            return;

        // if it has command properties then we add it to commands, if not just add the alias, so we can bind and unbind
        if (module.pCommand != null)
            mCommands.put("." + module.sCommandName, module.pCommand);

        mModuleCmdName.put(module.sCommandName, module);
    }
}
