package com.heisenbugdev.heisenui.core.api.view;

import com.heisenbugdev.heisenui.api.annotation.UIOutlet;
import com.heisenbugdev.heisenui.api.annotation.UITarget;
import com.heisenbugdev.heisenui.api.json.HeisenViewModel;
import com.heisenbugdev.heisenui.api.lib.IOutlet;
import com.heisenbugdev.heisenui.api.lib.ITarget;
import com.heisenbugdev.heisenui.api.view.IView;
import com.heisenbugdev.heisenui.api.view.IViewController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HeisenViewController implements IViewController
{
    public HeisenViewController parentViewController;
    private IView _view;

    //private HeisenViewModel data;
    private HashMap<String, IOutlet> _outlets;
    private HashMap<String, ITarget> _targets;

    public HeisenViewController(HeisenViewModel data, HeisenViewController parentViewController)
    {
        this.parentViewController = parentViewController;
        this._view = HeisenView.viewForData(data.getView());

        registerOutlets();
        registerTargets();

        this._view.connectOutlets(this.outlets());
        this._view.connectTargets(this.targets());
    }

    @Override
    public HeisenViewController parentViewController()
    {
        return parentViewController;
    }

    public HashMap<String, IOutlet> outlets()
    {
        if (this._outlets == null)
        {
            this._outlets = new HashMap<String, IOutlet>();
        }
        return this._outlets;
    }

    public HashMap<String, ITarget> targets()
    {
        if (this._targets == null)
        {
            this._targets = new HashMap<String, ITarget>();
        }
        return this._targets;
    }


    public void registerOutlets()
    {
        //HashMap<String, HeisenView> outlets = view().getOutlets();

        // gets all the fields
        Field[] fields = this.getClass().getFields();
        for (Field outlet : fields)
        {
            UIOutlet annotation = outlet.getAnnotation(UIOutlet.class);
            if (annotation == null) continue;

            String outletIdentifier = annotation.value();
            this.outlets().put(outletIdentifier, new Outlet(this, outlet));

        }
    }

    public void registerTargets()
    {
        // gets all the methods
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods)
        {
            UITarget annotation = method.getAnnotation(UITarget.class);
            if (annotation == null) continue;

            String targetIdentifier = annotation.value();
            Target target = new Target(this, method);
            this.targets().put(targetIdentifier, target);
        }
    }

    public IView view()
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
        //this._view = HeisenView.viewForData(this.data);
    }

    /**
     * Use this method to set up view subviews.
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
