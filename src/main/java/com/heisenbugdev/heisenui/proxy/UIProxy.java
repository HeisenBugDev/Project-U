package com.heisenbugdev.heisenui.proxy;

import com.heisenbugdev.heisenui.view.element.*;

public class UIProxy
{
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

}
