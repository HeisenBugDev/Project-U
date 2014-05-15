package com.heisenbugdev.heisenui;

import com.heisenbugdev.heisenui.logger.HeisenLogger;
import com.heisenbugdev.heisenui.proxy.UIProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@Mod(modid = HeisenProperties.MOD_IDENTIFICATION, name = HeisenProperties.MOD_NAME, version = HeisenProperties.MOD_VERSION)
public class HeisenUI
{

    public static final Boolean DEBUG = false;
    @Instance
    public static HeisenUI instance;
    @SidedProxy(clientSide = "com.heisenbugdev.heisenui.proxy.UIClientProxy", serverSide = "com.heisenbugdev.heisenui.proxy.UIProxy")
    public static UIProxy proxy;
    public static Item debugItem = new DebugItem();

    public HeisenUI()
    {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        if (!DEBUG)
        {
            HeisenLogger.info("Debugging is NOT enabled!");
        }
        else
        {
            HeisenLogger.info("Debugging is enabled!");
            GameRegistry.registerItem(debugItem, debugItem.getUnlocalizedName());
        }

    }

    /**
     * TODO: Implement this
     * @param identifier the identifier with the string
     */
    public void displayViewWithIdentifier(String identifier)
    {

    }
}