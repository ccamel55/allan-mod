package net.allan.mod.Modules.TestModule;

import net.allan.mod.Events.EventInGameHudRender;
import net.allan.mod.Utils.ChatMessage.ChatMessage;
import net.allan.mod.Utils.CommandManager.Interfaces.ModCommand;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.allan.mod.Utils.ModuleManager.Interfaces.ModModule;
import net.allan.mod.Utils.Renderer2D.Renderer2D;

import java.awt.*;

public class TestModule extends ModModule {

    public static class TestModuleCommand extends ModCommand {

        public TestModuleCommand() {
            super("Test auto command registration for a module", "NONE");
        }

        @Override
        public void handleMessage(String[] message) {
            ChatMessage.printChatMessage("sup");
        }

        @Override
        public boolean checkSyntax(String[] message) {
            return message.length >= 1;
        }
    }

    public TestModule() {

        sName = "Test Module";
        sCommandName = "tmod";

        iToggleKey = -1;
        bEnabled = false;

        bIsCheat = false;

        pCommand = new TestModuleCommand();
        pProperties = null;
    }

    // test that events are working
    @IListenableMethod()
    public void render(EventInGameHudRender e) {
        if (bEnabled)
            Renderer2D.drawText(20, 20, new Color(100, 100, 200, 255), "The method is on!");
    }
}
