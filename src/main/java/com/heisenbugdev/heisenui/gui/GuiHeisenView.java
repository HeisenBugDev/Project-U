package com.heisenbugdev.heisenui.gui;

import com.heisenbugdev.heisenui.core.api.view.HeisenView;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

/**
 * This class actually handles the @link(HeisenView) drawing, events, etc.
 * DO NOT SUBCLASS THIS UNLESS YOU ARE WORKING ON THE API.
 */
public class GuiHeisenView extends GuiContainer
{

    protected HeisenView _view;

    public GuiHeisenView(Container container, HeisenView view)
    {
        super(container);
        this._view = view;
    }

    public HeisenView view()
    {
        return this._view;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float delta, int x, int y)
    {
        this.view().drawBackgroundLayer();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
        this.view().drawForgroundLayer();
    }

    @Override
    public void initGui()
    {
        super.initGui();
        this.view().invokeTarget("initGui");
    }

    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();

    }
}
