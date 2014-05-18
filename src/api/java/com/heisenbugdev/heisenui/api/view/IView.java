package com.heisenbugdev.heisenui.api.view;

import java.util.Map;

public interface IView
{

    public String identifier();
    public void setIdentifier(String identifier);

    public HeisenFrame frame();
    public void setFrame(HeisenFrame frame);

    public boolean hidden();
    public void setHidden(boolean hidden);

    public void setAttributes(Map<String,Object> attributes);

    public Map<String, IView> subviews();

    public void addSubview(IView view);

    public void invokeTarget(String targetIdentifier);

    public void drawForgroundLayer();
    public void drawBackgroundLayer();
    public void draw(int mouseX, int mouseY);

}
