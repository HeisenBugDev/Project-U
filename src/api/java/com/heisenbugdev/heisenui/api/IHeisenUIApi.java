package com.heisenbugdev.heisenui.api;

import com.heisenbugdev.heisenui.api.view.IViewControllerRegistry;
import com.heisenbugdev.heisenui.api.view.IViewElementRegistry;

/**
 * Created by jacob on 5/17/14.
 */
public interface IHeisenUIApi
{

    public IViewControllerRegistry getViewControllerRegistry();
    public IViewElementRegistry getViewElementRegistry();
}
