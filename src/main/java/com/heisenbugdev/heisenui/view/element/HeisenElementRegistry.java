package com.heisenbugdev.heisenui.view.element;


import com.heisenbugdev.heisenui.proxy.UIProxy;
import com.heisenbugdev.heisenui.view.HeisenView;

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
            throw new IndexOutOfBoundsException(String.format("HeisenElementRegistry already contains a registered element for class: %s", name));
        }

        registry.put(name, clazz);
    }

    public Class<? extends HeisenView> getRegisteredViewClass(String name)
    {
        return registry.get(name);
    }
}
