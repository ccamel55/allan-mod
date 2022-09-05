package net.allan.mod;

import net.allan.mod.Modules.BlockOverlay.BlockOverlay;
import net.allan.mod.Modules.ClientInfo.ClientInfo;
import net.allan.mod.Modules.Crosshairs.Crosshairs;
import net.allan.mod.Modules.Fullbright.Fullbright;
import net.allan.mod.Modules.Keystrokes.Keystrokes;
import net.allan.mod.Modules.ReachDisplay.ReachDisplay;
import net.allan.mod.Modules.TntTimer.TntTimer;
import net.allan.mod.Modules.ToggleSprint.ToggleSprint;
import net.allan.mod.Utils.CommandManager.CommandManager;
import net.allan.mod.Utils.ConfigManager.ConfigManager;
import net.allan.mod.Utils.EventManager.EventManager;
import net.allan.mod.Utils.ModuleManager.Core.EModuleType;
import net.allan.mod.Utils.ModuleManager.ModuleManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

import java.io.File;

public class AllanMod implements ModInitializer {

	public static MinecraftClient client = null;

	@Override
	public void onInitialize() {
		client = MinecraftClient.getInstance();

		// check if our mod's folder exists
		final var modDir = getMinecraftDirectory();

		if (!modDir.exists())
			modDir.mkdirs();

		// modules must be registered first
		ModuleManager.add(EModuleType.Visuals, new BlockOverlay());
		ModuleManager.add(EModuleType.Visuals, new Crosshairs());
		ModuleManager.add(EModuleType.Visuals, new Keystrokes());
		ModuleManager.add(EModuleType.Visuals, new ReachDisplay());
		ModuleManager.add(EModuleType.Visuals, new TntTimer());

		ModuleManager.add(EModuleType.Misc, new ClientInfo());
		ModuleManager.add(EModuleType.Misc, new Fullbright());
		ModuleManager.add(EModuleType.Misc, new ToggleSprint());

		// we want to register all commands etc. using our modules
		EventManager.init();
		CommandManager.init();
		ConfigManager.init();
	}

	public static File getMinecraftDirectory() {
		return new File(client.runDirectory, "allan");
	}
}
