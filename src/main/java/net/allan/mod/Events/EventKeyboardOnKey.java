package net.allan.mod.Events;

import net.allan.mod.Utils.EventManager.Interfaces.EventCancellable;

public class EventKeyboardOnKey extends EventCancellable {

    public int iKey;
    public int iAction;

    public EventKeyboardOnKey(int key, int action) {
        iKey = key;
        iAction = action;
    }
}
