package com.heisenbugdev.heisenui.api.view;

import com.heisenbugdev.heisenui.api.lib.IOutlet;
import com.heisenbugdev.heisenui.api.lib.ITarget;

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

    public void connectOutlets(Map<String, IOutlet> outlets);
    public void connectTargets(Map<String, ITarget> targets);

    public void drawForgroundLayer();
    public void drawBackgroundLayer();
    public void draw(int mouseX, int mouseY);

}
