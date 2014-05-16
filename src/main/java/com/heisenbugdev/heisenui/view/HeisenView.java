package com.heisenbugdev.heisenui.view;

import com.heisenbugdev.heisenui.json.HeisenViewModel;
import com.heisenbugdev.heisenui.view.element.HeisenElementRegistry;

import java.util.Map;

public class HeisenView
{

    private HeisenViewModel.View data = null;

    public Map<String, HeisenView> subviews;
    private Map<String, Target> targets;


    public boolean hidden = false;
    public HeisenFrame frame;
    public String identifier = "";

    public HeisenView()
    {
    }

    public void addSubview(HeisenView view)
    {
        if (view != this)
        {
            subviews.put(view.identifier, view);
        }
    }

    public void invokeTarget(String targetIdentifier)
    {
        if (this.targets.containsKey(targetIdentifier))
        {
            this.targets.get(targetIdentifier).invoke();
        }
    }

    public void connectTargets(Map<String, Target> targets)
    {
        this.targets = targets;
    }

    public void connectOutlets(Map<String, Outlet> outlets)
    {
        for (Map.Entry<String, Outlet> outlet : outlets.entrySet())
        {
            HeisenView view = this.subviews.get(outlet.getKey());
            if (view != null)
            {
                outlet.getValue().set(view);
            }
        }

        for (HeisenView view : this.subviews.values())
        {
            view.connectOutlets(outlets);
        }
    }

    public void setAttributes(Map<String,Object> attributes) {}

    public void draw(float delta)
    {
        if (this.hidden) return;

        for (Map.Entry<String, HeisenView> entry : subviews.entrySet())
        {
            HeisenView subview = entry.getValue();
            subview.draw(delta);
        }
    }

    public static HeisenView viewForData(HeisenViewModel.View data)
    {
        HeisenView view = null;
        Class<? extends HeisenView> clazz = HeisenElementRegistry.INSTANCE.getRegisteredViewClass(data.getType());

        try
        {
            view = clazz.newInstance();
            view.frame = data.getFrame();
            view.hidden = data.isHidden();
            view.identifier = data.getIdentifier();
            view.setAttributes(data.getAttributes());

            for (HeisenViewModel.View subviewModel : data.getSubviews())
            {
                HeisenView subview = HeisenView.viewForData(subviewModel);
                view.addSubview(subview);
            }

            //for (HeisenViewModel.Outlet outlet : data.Out)
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
            return null;
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
            return null;
        }

        return view;
    }
}
