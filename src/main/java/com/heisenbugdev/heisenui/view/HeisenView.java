package com.heisenbugdev.heisenui.view;

import com.heisenbugdev.heisenui.json.HeisenViewModel;

import java.util.ArrayList;
import java.util.HashMap;

public class HeisenView
{

    public ArrayList<HeisenView> elements;

    private HashMap<String, HeisenView> outlets;
    private HashMap<String, Target> targets;


    public boolean hidden = false;
    public HeisenFrame frame;

    public HeisenView()
    {
    }

    public HeisenView(HashMap data)
    {
        this();

//        Map frameData = data.get("frame");

    }

    public HashMap<String, HeisenView> getOutlets()
    {
        return outlets;
    }

    public HashMap getTargets()
    {
        return targets;
    }

    public void draw(float delta)
    {
        if (this.hidden) return;

        for (HeisenView element : elements)
        {
            element.draw(delta);
        }
    }

    public void addSubview(HeisenView view)
    {
        if (view != this)
        {
            elements.add(view);
        }
    }


    public void executeTarget(String targetIdentifier)
    {
        if (this.targets.containsKey(targetIdentifier))
        {
            this.targets.get(targetIdentifier).invoke();
        }
    }

    public void registerTarget(String targetIdentifier, Target target)
    {
        if (this.targets.containsKey(targetIdentifier))
        {
            this.targets.remove(targetIdentifier);
        }

        this.targets.put(targetIdentifier, target);
    }

    public static HeisenView viewForData(HeisenViewModel data)
    {
        HeisenView view;
        //String type = data.el

        return null;
    }
}
