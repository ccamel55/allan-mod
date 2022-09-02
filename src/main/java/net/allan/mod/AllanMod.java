package net.allan.mod;

import net.allan.mod.Modules.ClientInfo.ClientInfo;
import net.allan.mod.Modules.Keystrokes.Keystrokes;
import net.allan.mod.Utils.CommandManager.CommandManager;
import net.allan.mod.Utils.EventManager.EventManager;
import net.allan.mod.Utils.ModuleManager.Core.EModuleType;
import net.allan.mod.Utils.ModuleManager.ModuleManager;
import net.allan.mod.Utils.TabGUI.TabGUI;
import net.fabricmc.api.ModInitializer;

public class AllanMod implements ModInitializer {

	@Override
	public void onInitialize() {

		// register all predefined commands
		CommandManager.init();

		// add our module to our modules list, they will have their own listeners that will be invoked when event is fired
		ModuleManager.add(EModuleType.Visuals, new ClientInfo());
		ModuleManager.add(EModuleType.Misc, new Keystrokes());

		// manually add our own listener for GUI, other modules will get added when they get created
		EventManager.register(new TabGUI());
	}
}
