package com.heisenbugdev.heisenui.proxy;

import com.heisenbugdev.heisenui.DebugItem;
import com.heisenbugdev.heisenui.core.api.view.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class UIProxy
{
    public static Item debugItem = new DebugItem();

    public void registerDefaultViewElements()
    {
        HeisenElementRegistry.INSTANCE.registerViewElement(HeisenButton.class);
        HeisenElementRegistry.INSTANCE.registerViewElement(HeisenCharacterView.class);
        HeisenElementRegistry.INSTANCE.registerViewElement(HeisenLabel.class);
        HeisenElementRegistry.INSTANCE.registerViewElement(HeisenTextField.class);
        HeisenElementRegistry.INSTANCE.registerViewElement(HeisenTextureView.class);
    }

    public static String nameForClass(Class clazz)
    {
        Class<?> enclosingClass = clazz.getEnclosingClass();
        if (enclosingClass != null)
        {
            return enclosingClass.getName();
        }
        else
        {
            return clazz.getName();
        }
    }

    public void debugSetup()
    {
        GameRegistry.registerItem(debugItem, debugItem.getUnlocalizedName());
    }
}
