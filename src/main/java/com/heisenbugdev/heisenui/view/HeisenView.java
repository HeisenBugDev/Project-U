package com.heisenbugdev.heisenui.view;

import com.heisenbugdev.heisenui.view.element.HeisenFrame;

import java.util.ArrayList;
import java.util.HashMap;

public class HeisenView
{

    public ArrayList<HeisenView> elements;

    private HashMap<String, HeisenView> outlets;
    private HashMap targets;

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

}
