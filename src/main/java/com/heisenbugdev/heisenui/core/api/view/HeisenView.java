package com.heisenbugdev.heisenui.core.api.view;

import com.heisenbugdev.heisenui.api.HeisenUIInfo;
import com.heisenbugdev.heisenui.api.json.HeisenViewModel;
import com.heisenbugdev.heisenui.api.view.HeisenFrame;
import com.heisenbugdev.heisenui.api.view.IView;

import java.util.HashMap;
import java.util.Map;

public class HeisenView implements IView
{
    private Map<String, IView> _subviews;
    private Map<String, Target> targets;

    private boolean _hidden = false;
    private HeisenFrame _frame;

    private String _identifier = "";

    public HeisenView() {}

    public Map<String, IView> subviews()
    {
        if (_subviews == null)
        {
            _subviews = new HashMap<String, IView>();
        }
        return _subviews;
    }

    @Override
    public void addSubview(IView view)
    {

    }

    public void addSubview(HeisenView view)
    {
        if (view != this)
        {
            subviews().put(view.identifier(), view);
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
            IView view = this.subviews().get(outlet.getKey());
            if (view != null)
            {
                outlet.getValue().set(view);
            }
        }

        for (IView view : this.subviews().values())
        {
            ((HeisenView)view).connectOutlets(outlets);
        }
    }

    public void setAttributes(Map<String,Object> attributes) {}

    @Override
    public String identifier()
    {
        return this._identifier;
    }

    @Override
    public void setIdentifier(String identifier)
    {
        this._identifier = identifier;
    }

    @Override
    public HeisenFrame frame()
    {
        return this._frame;
    }

    @Override
    public void setFrame(HeisenFrame frame)
    {
        this._frame = frame;
    }

    @Override
    public boolean hidden()
    {
        return false;
    }

    @Override
    public void setHidden(boolean hidden)
    {

    }

    public void drawForgroundLayer()
    {
        if (this.hidden()) return;

        for (Map.Entry<String, IView> entry : subviews().entrySet())
        {
            IView subview = entry.getValue();
            subview.drawForgroundLayer();
        }
    }

    public void drawBackgroundLayer()
    {
        if (this.hidden()) return;

        for (Map.Entry<String, IView> entry : subviews().entrySet())
        {
            IView subview = entry.getValue();
            subview.drawBackgroundLayer();
        }
    }

    public void draw(int mouseX, int mouseY)
    {
        if (this.hidden()) return;

        for (Map.Entry<String, IView> entry : subviews().entrySet())
        {
            IView subview = entry.getValue();
            subview.draw(mouseX, mouseY);
        }
    }

    public static IView viewForData(HeisenViewModel.View data)
    {
        IView view = null;
        Class<? extends IView> clazz = HeisenUIInfo.api().getViewElementRegistry().getRegisteredViewClass(data.getType());
        if (clazz == null) clazz = HeisenView.class;

        try
        {
            view = clazz.newInstance();
            view.setFrame(data.getFrame());
            view.setHidden(data.isHidden());
            view.setIdentifier(data.getIdentifier());
            view.setAttributes(data.getAttributes());

            if (data.getSubviews() != null)
            {
                for (HeisenViewModel.View subviewModel : data.getSubviews())
                {
                    IView subview = HeisenView.viewForData(subviewModel);
                    view.addSubview(subview);
                }
            }
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
