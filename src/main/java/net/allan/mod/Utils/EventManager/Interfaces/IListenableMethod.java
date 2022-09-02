package net.allan.mod.Utils.EventManager.Interfaces;

import net.allan.mod.Utils.EventManager.Core.EventPriority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IListenableMethod {
    byte bPriority() default EventPriority.NORMAL;
}
