package com.heisenbugdev.heisenui.view;

import com.heisenbugdev.heisenui.json.Map;
import com.heisenbugdev.heisenui.logger.HeisenLogger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HeisenViewController
{

    public HeisenViewController parentViewController;
    private HeisenView _view;

    private Map data;

    public HeisenViewController(Map data, HeisenViewController parentViewController)
    {
        this.parentViewController = parentViewController;
        this.data = data;

        connectOutlets();
        connectTargets();

    }

    private void connectOutlets()
    {
        HashMap<String, HeisenView> outlets = view().getOutlets();

        // gets all the fields
        Field[] fields = this.getClass().getFields();
        for (Field outlet : fields)
        {
            UIOutlet annotation = outlet.getAnnotation(UIOutlet.class);
            if (annotation == null) continue;

            String outletIdentifier = annotation.value();
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

    private void connectTargets()
    {
        // gets all the methods
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods)
        {
            UITarget annotation = method.getAnnotation(UITarget.class);
            if (annotation == null) continue;

            String targetIdentifier = annotation.value();
            Target target = new Target(this, method);
            this.view().registerTarget(targetIdentifier, target);
        }
    }

    public HeisenView view()
    {
        if (this._view == null)
        {
            this.loadView();
        }
        return this._view;
    }


    /**
     * Do NOT call this method or override it yourself.
     */
    public void loadView()
    {
        this._view = HeisenView.viewForData(this.data);
    }

    /**
     * Use this method to set up view elements.
     */
    @UITarget("initGui")
    public void initGui()
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

    public void guiDidLoad()
    {

    }

}
