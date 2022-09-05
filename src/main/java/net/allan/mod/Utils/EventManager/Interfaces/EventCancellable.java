package net.allan.mod.Utils.EventManager.Interfaces;

public abstract class EventCancellable{

    private boolean bCancelled = false;

    public boolean isCancelled() {
        return bCancelled;
    }

    public void setCancelled(boolean val) {
        bCancelled = val;
    }
}
