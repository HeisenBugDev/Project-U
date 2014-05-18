package com.heisenbugdev.heisenui.api.view;

public interface IButton
{

    public String text();
    public void setText(String text);
    public boolean enabled();
    public void setEnabled(boolean enabled);
    public int buttonId();
    public void setButtonId(int buttonId);
}
