package com.heisenbugdev.heisenui.view;

import java.lang.reflect.Field;

public class Outlet
{
    public Outlet(Object objectInstance, Field field)
    {
        this.field = field;
        this.objectInstance = objectInstance;
    }

    private Field field;
    private Object objectInstance;

    public void set(HeisenView value)
    {
        try
        {
            this.field.set(objectInstance, value);
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Field getField()
    {
        return field;
    }

    public Object getObjectInstance()
    {
        return objectInstance;
    }
}
