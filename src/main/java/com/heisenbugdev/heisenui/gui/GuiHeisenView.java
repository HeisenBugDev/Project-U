package com.heisenbugdev.heisenui.gui;

import com.heisenbugdev.heisenui.view.HeisenView;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

/**
 * This class actually handles the @link(HeisenView) drawing, events, etc.
 * DO NOT SUBCLASS THIS UNLESS YOU ARE WORKING ON THE API.
 */
public interface GuiHeisenView
{

    public HeisenView view();

    public static class GuiHeisenViewBase extends Gui implements GuiHeisenView
    {
        private HeisenView view;

        public GuiHeisenViewBase(HeisenView view)
        {
            this.view = view;
        }

        public HeisenView view()
        {
            return this.view;
        }

    }

    public static class GuiHeisenViewScreen extends GuiScreen implements GuiHeisenView
    {
        private HeisenView view;

        public GuiHeisenViewScreen(HeisenView view)
        {
            this.view = view;
        }

        public HeisenView view()
        {
         return this.view;
        }

    }

    public static class GuiHeisenViewContainer extends GuiContainer implements GuiHeisenView
    {
        private HeisenView view;

        public GuiHeisenViewContainer(Container container, HeisenView view)
        {
            super(container);
            this.view = view;
        }

        public HeisenView view()
        {
            return this.view;
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float delta, int x, int y)
        {

        }

        @Override
        public void initGui()
        {
            super.initGui();
            this.view().invokeTarget("initGui");

        }
    }

}
