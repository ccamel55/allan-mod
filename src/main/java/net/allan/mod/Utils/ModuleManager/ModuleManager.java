package net.allan.mod.Utils.ModuleManager;

import net.allan.mod.Utils.ModuleManager.Core.EModuleType;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {

    public static Map<String, Map<String, ModModule>> mModules = new HashMap<>();

    public static void add(EModuleType type, ModModule module) {
        if (!mModules.containsKey(type.toString()))
            mModules.put(type.toString(), new HashMap<>());

        mModules.get(type.toString()).put(module.sName, module);
    }

    public static void remove(ModModule module) {

    }
}
