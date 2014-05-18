package com.heisenbugdev.heisenui.api.view;

/**
 * Defines a view frame, or the box.
 */
public class HeisenFrame
{

    protected int _x;
    protected int _y;

    protected int xOffset;
    protected int yOffset;

    public int width;
    public int height;

    private HeisenOrigin _origin = HeisenOrigin.TOP_LEFT;

    public HeisenFrame(int x, int y, int width, int height)
    {
        this._x = x;
        this._y = y;
        this.width = width;
        this.height = height;
    }

    public HeisenFrame(int x, int y, int width, int height, HeisenOrigin origin)
    {
        this(x, y, width, height);
        this._origin = origin;
    }

    public int x()
    {
        return _x + xOffset;
    }

    public void setX(int x)
    {
        this._x = x;
        this.xOffset = (int)(x * origin().xOffsetMultiplier);
    }

    public int y()
    {
        return _y + yOffset;
    }

    public void setY(int y)
    {
        this._y = y;
        this.yOffset = (int)(y * origin().yOffsetMultiplier);
    }

    public HeisenOrigin origin()
    {
        return _origin;
    }
}
