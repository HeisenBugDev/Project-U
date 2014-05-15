package com.heisenbugdev.heisenui.view;

import com.heisenbugdev.heisenui.logger.HeisenLogger;

import java.lang.reflect.Field;
import java.util.HashMap;

public class HeisenViewController
{

    public HeisenViewController parentViewController;
    public HeisenView view;


    public HeisenViewController()

    {

    }

    private void connectOutlets()
    {
        HashMap<String, HeisenView> outlets = view.getOutlets();

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field outlet : fields)
        {
            Outlet annotation = outlet.getAnnotation(Outlet.class);
            if (annotation != null)
            {
                String outletIdentifier = annotation.identification();
                HeisenView outletValue = outlets.get(outletIdentifier);
                try
                {
                    outlet.set(this, outletValue);
                }
                catch (Exception e)
                {
                    HeisenLogger.fatal(String.format("Could not set outlet: %s to value %s", outletIdentifier, outletValue));
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void connectTargets()
    {

    }

    public void guiWillAppear()
    {
    }

    public void guiDidAppear()
    {
    }

    public void guiWillDisappear()
    {
    }

    public void guiDidDisappear()
    {
    }
}
