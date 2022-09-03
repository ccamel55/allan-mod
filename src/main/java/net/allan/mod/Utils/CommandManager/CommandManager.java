package net.allan.mod.Utils.CommandManager;

import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.Core.CommandBind;
import net.allan.mod.Utils.CommandManager.Core.CommandConfig;
import net.allan.mod.Utils.CommandManager.Core.CommandHelp;
import net.allan.mod.Utils.CommandManager.Core.CommandToggle;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;
import net.allan.mod.Utils.ModuleManager.ModuleManager;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    public static char commandPrefix = '.';

    //the rest of all our commands belong in a hash map
    public static Map<String, ModCommand> mCommands = new HashMap<>();
    public static Map<String, ModModule> mModuleCmdName = new HashMap<>();

    public static void init() {
        // we have 3 basic build int commands, help, bind and toggle
        register("help", new CommandHelp());
        register("bind", new CommandBind());
        register("toggle", new CommandToggle());
        register("config", new CommandConfig());

        // add commands from our modules
        for (final var moduleType : ModuleManager.mModules.values()) {
            for (final var module : moduleType.values()) {
                // we need to register the module name, so we can use it in other commands later,
                //  if the module has its own commands, we also need to register those commands

                if (mModuleCmdName.containsKey(module.sCommandName))
                    return;

                if (module.pCommand != null)
                    mCommands.put(commandPrefix + module.sCommandName, module.pCommand);

                mModuleCmdName.put(module.sCommandName, module);
            }
        }
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

    public static void register(String commandName, ModCommand command) {
        final var commandNameFixed = commandPrefix + commandName;

        if (mCommands.containsKey(commandNameFixed))
            return;

        mCommands.put(commandNameFixed, command);
    }
}
