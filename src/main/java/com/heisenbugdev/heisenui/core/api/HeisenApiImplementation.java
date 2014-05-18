package com.heisenbugdev.heisenui.core.api;

import com.heisenbugdev.heisenui.api.HeisenUIInfo;
import com.heisenbugdev.heisenui.api.view.IViewControllerRegistry;
import com.heisenbugdev.heisenui.api.view.IViewElementRegistry;
import com.heisenbugdev.heisenui.core.api.view.element.HeisenElementRegistry;

public final class HeisenApiImplementation extends HeisenUIInfo
{

    public void enable()
    {
        this._api = this;
    }


    @Override
    public IViewControllerRegistry getViewControllerRegistry()
    {
        return HeisenViewControllerRegistry.INSTANCE;
    }

    @Override
    public IViewElementRegistry getViewElementRegistry()
    {
        return HeisenElementRegistry.INSTANCE;
    }
}
