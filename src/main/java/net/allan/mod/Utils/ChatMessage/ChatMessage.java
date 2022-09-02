package net.allan.mod.Utils.ChatMessage;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ChatMessage {

    public static void printChatMessage(String message) {

        final var printMsg = "\u00A76[allan-mod] \u00A77" + message;
        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of(printMsg));
    }
}
