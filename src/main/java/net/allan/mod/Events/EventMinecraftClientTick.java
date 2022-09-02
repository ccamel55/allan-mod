package net.allan.mod.Events;

import net.allan.mod.Utils.EventManager.Interfaces.IEvent;

public class EventMinecraftClientTick implements IEvent {

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
