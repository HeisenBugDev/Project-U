package com.heisenbugdev.heisenui.api.view;

import com.heisenbugdev.heisenui.api.view.IView;

public interface IViewElementRegistry
{

    public void registerViewElement(Class<? extends IView> clazz);
    public Class<? extends IView> getRegisteredViewClass(String name);
}
