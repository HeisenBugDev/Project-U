package com.heisenbugdev.heisenui.api;

import cpw.mods.fml.common.ModContainer;

import java.io.InputStream;

/**
 * Created by jacob on 5/17/14.
 */
public interface IViewControllerRegistry
{

    public void registerJsonView(String json, ModContainer mod);
    public void registerJsonView(InputStream jsonFile, ModContainer mod);
    //public void register

}
