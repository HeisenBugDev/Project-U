package com.heisenbugdev.heisenui.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Target
{
    public Target(Object objectInstance, Method method)
    {
        this.method = method;
        this.objectInstance = objectInstance;
    }

    public Method method;
    public Object objectInstance;

    public void invoke(Object... args)
    {
        // try to invoke the method with no error tolerance.
        try
        {
            this.method.invoke(objectInstance, args);
        }
        catch (InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }
}
