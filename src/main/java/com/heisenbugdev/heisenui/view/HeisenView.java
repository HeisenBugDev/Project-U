package com.heisenbugdev.heisenui.view;

import java.util.HashMap;

public class HeisenView
{

    private HashMap<String, HeisenView> outlets;
    private HashMap targets;


    public HashMap<String, HeisenView> getOutlets()
    {
        return outlets;
    }

    public HashMap getTargets()
    {
        return targets;
    }
}
