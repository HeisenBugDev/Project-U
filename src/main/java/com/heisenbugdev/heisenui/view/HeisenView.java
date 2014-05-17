package com.heisenbugdev.heisenui.view;

import com.heisenbugdev.heisenui.json.HeisenViewModel;
import com.heisenbugdev.heisenui.view.element.HeisenElementRegistry;

import java.util.HashMap;
import java.util.Map;

public class HeisenView
{
    public Map<String, HeisenView> _subviews;
    private Map<String, Target> targets;

    public boolean hidden = false;
    public HeisenFrame frame;
    public String identifier = "";

    public HeisenView() {}

    public Map<String, HeisenView> subviews()
    {
        if (_subviews == null)
        {
            _subviews = new HashMap<String, HeisenView>();
        }
        return _subviews;
    }

    public void addSubview(HeisenView view)
    {
        if (view != this)
        {
            subviews().put(view.identifier, view);
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
            HeisenView view = this.subviews().get(outlet.getKey());
            if (view != null)
            {
                outlet.getValue().set(view);
            }
        }

        for (HeisenView view : this.subviews().values())
        {
            view.connectOutlets(outlets);
        }
    }

    public void setAttributes(Map<String,Object> attributes) {}

    public void draw(float delta)
    {
        if (this.hidden) return;

        for (Map.Entry<String, HeisenView> entry : subviews().entrySet())
        {
            HeisenView subview = entry.getValue();
            subview.draw(delta);
        }
    }

    public static HeisenView viewForData(HeisenViewModel.View data)
    {
        HeisenView view = null;
        Class<? extends HeisenView> clazz = HeisenElementRegistry.INSTANCE.getRegisteredViewClass(data.getType());
        if (clazz == null) clazz = HeisenView.class;

        try
        {
            view = clazz.newInstance();
            view.frame = data.getFrame();
            view.hidden = data.isHidden();
            view.identifier = data.getIdentifier();
            view.setAttributes(data.getAttributes());

            if (data.getSubviews() != null)
            {
                for (HeisenViewModel.View subviewModel : data.getSubviews())
                {
                    HeisenView subview = HeisenView.viewForData(subviewModel);
                    view.addSubview(subview);
                }
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
