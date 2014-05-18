package com.heisenbugdev.heisenui.api.view;


import com.heisenbugdev.heisenui.api.annotation.UITarget;

import java.util.HashMap;

public interface IViewController
{

    public HashMap outlets();
    public HashMap targets();
    public IView view();

    public IViewController parentViewController();

    public void registerOutlets();
    public void registerTargets();

    /**
     * Do NOT call this method or override it yourself.
     */
    public void loadView();

    /**
     * Use this method to set up view subviews.
     */
    @UITarget("initGui")
    public void initGui();

    public void guiWillAppear();
    public void guiDidAppear();
    public void guiWillDisappear();
    public void guiDidDisappear();
    public void guiDidLoad();
}
