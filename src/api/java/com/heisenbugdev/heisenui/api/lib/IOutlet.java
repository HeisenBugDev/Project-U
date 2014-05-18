package com.heisenbugdev.heisenui.api.lib;

import com.heisenbugdev.heisenui.api.view.IView;

import java.lang.reflect.Field;

public interface IOutlet
{
    public void set(IView value);

    public Field getField();
    public Object getObjectInstance();
}
