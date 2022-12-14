package net.allan.mod.Utils.EventManager;

import net.allan.mod.Utils.EventManager.Core.EventListenerMethod;
import net.allan.mod.Utils.EventManager.Interfaces.EventCancellable;
import net.allan.mod.Utils.EventManager.Interfaces.IListenableMethod;
import net.allan.mod.Utils.ModuleManager.ModuleManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("unchecked")
public class EventManager {

    public static Map<Class<? extends EventCancellable>, List<EventListenerMethod>> mRegisteredListeners = new HashMap<>();

    public static void init() {
        // add all currently registered modules to our events list
        for (final var moduleType : ModuleManager.mModules.values()) {
            for (final var module : moduleType.values())
                register(module);
        }
    }

    public static void register(Object object) {
        for (final var method : object.getClass().getDeclaredMethods()) {
            // we only add methods that have be annotated as listeners
            if (method.getParameterTypes().length != 1 || !method.isAnnotationPresent(IListenableMethod.class))
                continue;

            register(object, method);
        }
    }

    public static void register(Object object, Class<? extends EventCancellable> eventClass) {
        for (final var method : object.getClass().getDeclaredMethods()) {
            // we only add methods that have be annotated as listeners and also have the class as the event we specified
            if (method.getParameterTypes().length != 1 || !method.isAnnotationPresent(IListenableMethod.class) || !method.getParameterTypes()[0].equals(eventClass))
                continue;

            register(object, method);
        }
    }

    private static void register(Object object, Method method) {
        // the first parameter of any listenable method will be the event that will invoke it
        final var listenerType = (Class<? extends EventCancellable>)method.getParameterTypes()[0];
        final var listenerMethod = new EventListenerMethod(object, method, method.getAnnotation(IListenableMethod.class).bPriority());

        if (!mRegisteredListeners.containsKey(listenerType))
            mRegisteredListeners.put(listenerType, new CopyOnWriteArrayList<>());

        final var listenerMap = mRegisteredListeners.get(listenerType);

        if (listenerMap.contains(listenerMethod))
            return;

        int i = 0;
        for (; i < listenerMap.size(); i++) {
            // if our listener has a higher priority than anything else, we insert before it
            if (listenerMethod.bPriority > listenerMap.get(i).bPriority)
                break;
        }

        listenerMethod.mMethod.setAccessible(true);
        listenerMap.add(i, listenerMethod);
    }

    public static void unregister(Object object) {
        for (final var event : mRegisteredListeners.values()) {
            event.removeIf(method -> method.oSuperType.equals(object));
        }
    }

    public static void unregister(Object object, Class<? extends EventCancellable> event) {
        if (!mRegisteredListeners.containsKey(event))
            return;

        mRegisteredListeners.get(event).removeIf(method -> method.oSuperType.equals(object));
    }

    public static void call(EventCancellable event) {
        final var eventListeners = mRegisteredListeners.get((event.getClass()));

        if (eventListeners == null)
            return;

        for (final var method : eventListeners) {
            try {
                method.mMethod.invoke(method.oSuperType, event);

                if (event.isCancelled())
                    break;
            }
            catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void removeAllMethods() {
        for (final var event : mRegisteredListeners.values()) {
            event.clear();
        }
    }
}
