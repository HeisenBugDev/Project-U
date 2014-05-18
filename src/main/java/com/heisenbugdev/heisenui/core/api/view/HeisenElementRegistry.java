package com.heisenbugdev.heisenui.core.api.view;


import com.heisenbugdev.heisenui.api.view.IView;
import com.heisenbugdev.heisenui.api.view.IViewElementRegistry;
import com.heisenbugdev.heisenui.logger.HeisenLogger;
import com.heisenbugdev.heisenui.proxy.UIProxy;

import java.util.HashMap;

public enum HeisenElementRegistry implements IViewElementRegistry
{
    INSTANCE;

    public HashMap<String, Class<? extends IView>> registry;

    private HeisenElementRegistry()
    {
        registry = new HashMap<String, Class<? extends IView>>();
    }

    @Override
    public void registerViewElement(Class<? extends IView> clazz)
    {
        String name = UIProxy.nameForClass(clazz);
        if (this.registry.containsKey(name))
        {
            HeisenLogger.warn(String.format("[HeisenElementRegistry] Warning: Tried to register view element class, %s, twice.", name));
            return;
        }

        registry.put(name, clazz);
    }

    @Override
    public Class<? extends IView> getRegisteredViewClass(String name)
    {
        return registry.get(name);
    }
}
