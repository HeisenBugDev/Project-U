package com.heisenbugdev.heisenui.core.api.view;

import com.heisenbugdev.heisenui.api.lib.IOutlet;
import com.heisenbugdev.heisenui.api.view.IView;

import java.lang.reflect.Field;

public class Outlet implements IOutlet
{
    public Outlet(Object objectInstance, Field field)
    {
        this.field = field;
        this.objectInstance = objectInstance;
    }

    private Field field;
    private Object objectInstance;

    public void set(IView value)
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
