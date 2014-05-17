package com.heisenbugdev.heisenui.view;

public enum HeisenOrigin
{
    TOP_LEFT(0, 0),
    TOP_RIGHT(1, 0),
    BOTTOM_LEFT(0, 1),
    BOTTOM_RIGHT(1, 1),
    CENTER(0.5, 0.5);

    public final double xOffsetMultiplier, yOffsetMultiplier;

    HeisenOrigin(double xOffsetMultiplier, double yOffsetMultiplier)
    {
        this.xOffsetMultiplier = xOffsetMultiplier;
        this.yOffsetMultiplier = yOffsetMultiplier;
    }


}
