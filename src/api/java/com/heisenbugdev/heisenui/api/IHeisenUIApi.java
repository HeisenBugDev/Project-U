package com.heisenbugdev.heisenui.api;

import com.heisenbugdev.heisenui.api.view.IViewControllerRegistry;
import com.heisenbugdev.heisenui.api.view.IViewElementRegistry;

/**
 * This class is how you interface with HeisenUI.
 */
public interface IHeisenUIApi
{

    public IViewControllerRegistry getViewControllerRegistry();
    public IViewElementRegistry getViewElementRegistry();
}
