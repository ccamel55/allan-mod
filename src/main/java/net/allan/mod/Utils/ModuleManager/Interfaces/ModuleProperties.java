package net.allan.mod.Utils.ModuleManager.Interfaces;

import java.util.HashMap;
import java.util.Map;

public class ModuleProperties {

    public boolean pHasProperties = false;
    public Map<String, Property<?>> mProperties = new HashMap<>();

    public void addProperty(Property<?> prop) {

    }
}
