package com.heisenbugdev.heisenui.core.api.view;

import com.heisenbugdev.heisenui.api.view.ICharacterView;
import com.heisenbugdev.heisenui.core.api.view.HeisenView;
import net.minecraft.entity.player.EntityPlayer;

public class HeisenCharacterView extends HeisenView implements ICharacterView
{
    private EntityPlayer _player;

    public HeisenCharacterView(EntityPlayer player)
    {
        this._player = player;
    }

    @Override
    public EntityPlayer player()
    {
        return this._player;
    }

    @Override
    public void setPlayer(EntityPlayer player)
    {
        this._player = player;
    }
}
