package net.allan.mod.Utils.ModuleManager;

import net.allan.mod.Utils.CommandManager.CommandManager;
import net.allan.mod.Utils.EventManager.EventManager;
import net.allan.mod.Utils.ModuleManager.Core.EModuleType;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ModuleManager {

    public static Map<EModuleType, List<ModModule>> mModules = new HashMap<>();

    public static void add(EModuleType type, ModModule module) {

        if (!mModules.containsKey(type))
            mModules.put(type, new CopyOnWriteArrayList<>());

        EventManager.register(module);
        CommandManager.addModule(module);

        mModules.get(type).add(module);
    }

    public static void remove(ModModule module) {

    }
}
