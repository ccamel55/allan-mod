package net.allan.mod.Events;

import net.allan.mod.Utils.EventManager.Interfaces.IEvent;

public class EventKeyboardOnKey implements IEvent {

    public int iKey;
    public int iAction;

    public EventKeyboardOnKey(int key, int action) {
        iKey = key;
        iAction = action;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
