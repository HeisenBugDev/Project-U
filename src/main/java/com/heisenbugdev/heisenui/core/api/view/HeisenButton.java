package com.heisenbugdev.heisenui.core.api.view;

import com.heisenbugdev.heisenui.api.view.HeisenFrame;
import com.heisenbugdev.heisenui.api.view.IButton;
import com.heisenbugdev.heisenui.core.api.view.HeisenView;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class HeisenButton extends HeisenView implements IButton
{

    private GuiButton button;

    public HeisenButton(HeisenFrame frame, int id, String text)
    {
        this.button = new GuiButton(id, frame.x(), frame.y(), text);
    }

    @Override
    public String text()
    {
        return this.button.displayString;
    }

    @Override
    public void setText(String text)
    {
        this.button.displayString = text;
    }

    @Override
    public boolean enabled()
    {
        return false;
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        this.button.enabled = enabled;
    }

    @Override
    public int buttonId()
    {
        return this.button.id;
    }

    @Override
    public void setButtonId(int buttonId)
    {
        this.button.id = buttonId;
    }

    @Override
    public void draw(int mouseX, int mouseY)
    {
        super.draw(mouseX, mouseY);
        button.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
    }
}