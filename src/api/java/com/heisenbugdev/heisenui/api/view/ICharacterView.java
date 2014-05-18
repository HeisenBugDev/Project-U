package com.heisenbugdev.heisenui.api.view;

import net.minecraft.entity.player.EntityPlayer;

public interface ICharacterView
{
    public EntityPlayer player();
    public void setPlayer(EntityPlayer player);
}
