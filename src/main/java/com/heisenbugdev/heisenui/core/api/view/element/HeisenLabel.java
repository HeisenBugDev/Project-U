package com.heisenbugdev.heisenui.core.api.view.element;

import com.heisenbugdev.heisenui.api.view.ILabel;
import com.heisenbugdev.heisenui.core.api.view.HeisenView;

public class HeisenLabel extends HeisenView implements ILabel
{

    private String _text;

    public HeisenLabel(String text)
    {
        this._text = text;
    }

    @Override
    public String text()
    {
        return this._text;
    }

    @Override
    public void setText(String text)
    {
        this._text = text;
    }
}
