package com.heisenbugdev.heisenui;

import com.heisenbugdev.heisenui.core.api.HeisenApiImplementation;
import com.heisenbugdev.heisenui.proxy.UIProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = HeisenProperties.MOD_IDENTIFICATION, name = HeisenProperties.MOD_NAME, version = HeisenProperties.MOD_VERSION)
public class HeisenUI
{

    public static final Boolean DEBUG = false;
    @Instance
    public static HeisenUI instance;
    @SidedProxy(clientSide = "com.heisenbugdev.heisenui.proxy.UIClientProxy", serverSide = "com.heisenbugdev.heisenui.proxy.UIProxy")
    public static UIProxy proxy;

    public static HeisenApiImplementation api;

    public HeisenUI()
    {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        if (this.DEBUG)
        {
            this.proxy.debugSetup();
        }

        this.api = new HeisenApiImplementation();
        this.proxy.registerDefaultViewElements();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        api.enable();
    }
}