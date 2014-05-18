package com.heisenbugdev.heisenui.core.api.view;

import com.heisenbugdev.heisenui.api.view.ITextField;
import com.heisenbugdev.heisenui.core.api.view.HeisenView;
import net.minecraft.client.gui.GuiTextField;

// TODO: Finish implementation.
public class HeisenTextField extends HeisenView implements ITextField
{

    private String _defaultText;
    protected GuiTextField textField;

    public HeisenTextField(String defaultText)
    {
        this._defaultText = defaultText;

        // TODO: Text renderer
        this.textField = new GuiTextField(null, this.frame().x(), this.frame().y(), this.frame().width, this.frame().height);
    }


    @Override
    public void keyTyped(char key)
    {

    }

    @Override
    public void activated()
    {

    }

    @Override
    public String text()
    {
        return null;
    }

    @Override
    public void setText(String text)
    {
        this.textField.setText(text);
    }
}
