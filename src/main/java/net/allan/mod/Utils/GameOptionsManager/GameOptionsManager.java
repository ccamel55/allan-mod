package net.allan.mod.Utils.GameOptionsManager;

import net.minecraft.client.option.SimpleOption;

import java.util.HashMap;
import java.util.Map;

public class GameOptionsManager {

    public static Map<SimpleOption<?>, Boolean> mIgnoreCheck = new HashMap<>();

    public static void addIgnoreCheck(SimpleOption<?> option) {
        if (!mIgnoreCheck.containsKey(option)) {
            mIgnoreCheck.put(option, true);
        }
    }
}
