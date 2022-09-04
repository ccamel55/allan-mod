package net.allan.mod.Utils.ConfigManager;

import net.allan.mod.AllanMod;
import net.allan.mod.Utils.ConfigManager.Core.YamlHelper;
import net.allan.mod.Utils.ModuleManager.ModuleManager;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ConfigManager {

    private static File configFile;
    private static YamlHelper yamlHelper;

    private static final String CONFIG_NAME = "settings.yml";

    public static void init() {
        // create the file if it doesn't exist
        configFile = new File(AllanMod.getMinecraftDirectory(), CONFIG_NAME);
        yamlHelper = new YamlHelper();

        // autoload from last save
        load();
    }

    public static boolean load() {

        if (!configFile.exists())
            return false;

        // write settings from the file to game options
        Map<String, Object> yamlMap = yamlHelper.readFile(configFile);

        if (yamlMap == null || yamlMap.isEmpty())
            return false;

        yamlMap.forEach((categoryS, categoryO) -> {

            // our big map will contain a smaller map that will have another map :(
            Map<String, Object> categoryMap = (Map<String, Object>)categoryO;

            categoryMap.forEach((moduleS, moduleO) -> {

                final var module = ModuleManager.mModules.get(categoryS).get(moduleS);

                if (module != null) {
                    Map<String, Object> moduleMap = (Map<String, Object>)moduleO;

                    module.iToggleKey = (int)moduleMap.get("key");
                    module.bEnabled =  (boolean)moduleMap.get("enabled");

                    // load any properties
                }
            });
        });

        return true;
    }

    public static boolean save() {

        if (!configFile.exists()) {
            // ngl no idea wtf this does but hey it works??
            try {
                final var printWriter = new PrintWriter(new FileWriter(configFile));
                printWriter.println();
                printWriter.close();

                final var fw = new FileWriter(configFile);
                fw.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        Map<String, Object> yamlMap = new HashMap<>();

        // bruh code
        for (final var categoryS : ModuleManager.mModules.keySet()) {
            Map<String, Object> categoryMap = new HashMap<>();

            for (final var module :  ModuleManager.mModules.get(categoryS).values()) {

                Map<String, Object> moduleMap = new HashMap<>();

                moduleMap.put("key", module.iToggleKey);
                moduleMap.put("enabled", module.bEnabled);

                // store any properties


                categoryMap.put(module.sName, moduleMap);
            }
            yamlMap.put(categoryS.toString(), categoryMap);
        }
        yamlHelper.writeFile(yamlMap, configFile);

        return true;
    }
}
