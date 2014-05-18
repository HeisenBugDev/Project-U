package com.heisenbugdev.heisenui.api.view;

import cpw.mods.fml.common.ModContainer;

import java.io.InputStream;

public interface IViewControllerRegistry
{

    public void registerJsonView(String json, ModContainer mod);
    public void registerJsonView(InputStream jsonFile, ModContainer mod);

}
