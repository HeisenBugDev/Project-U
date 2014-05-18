package com.heisenbugdev.heisenui.core.api.view.element;


import com.heisenbugdev.heisenui.api.view.HeisenView;
import com.heisenbugdev.heisenui.logger.HeisenLogger;
import com.heisenbugdev.heisenui.proxy.UIProxy;

import java.util.HashMap;

public enum HeisenElementRegistry
{
    INSTANCE;

    public HashMap<String, Class<? extends HeisenView>> registry;

    private HeisenElementRegistry()
    {
        registry = new HashMap<String, Class<? extends HeisenView>>();
    }

    public void registerViewElement(Class<? extends HeisenView> clazz)
    {
        String name = UIProxy.nameForClass(clazz);
        if (this.registry.containsKey(name))
        {
            HeisenLogger.warn(String.format("[HeisenElementRegistry] Warning: Tried to register view element class, %s, twice.", name));
            return;
        }

        registry.put(name, clazz);
    }

    public Class<? extends HeisenView> getRegisteredViewClass(String name)
    {
        return registry.get(name);
    }
}
