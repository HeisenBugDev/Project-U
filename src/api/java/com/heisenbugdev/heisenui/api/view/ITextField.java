package com.heisenbugdev.heisenui.api.view;

import com.heisenbugdev.heisenui.api.view.IView;

public interface ITextField extends IView
{

    public void keyTyped(char key);
    public void activated();
    public String text();
    public void setText(String text);
}
