package com.heisenbugdev.heisenui.api.lib;

import java.lang.reflect.Method;

public interface ITarget
{
    public void invoke(Object... args);

    public Method getMethod();
    public Object getObjectInstance();
}
