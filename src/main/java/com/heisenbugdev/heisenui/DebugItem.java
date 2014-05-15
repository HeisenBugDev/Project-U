package com.heisenbugdev.heisenui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DebugItem extends Item
{

    public DebugItem()
    {
        this.setUnlocalizedName("debugItem");
        this.setMaxStackSize(1);

        this.setCreativeTab(CreativeTabs.tabAllSearch);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        //player.openGui(HeisenProperties.MOD_IDENTIFICATION, GUIID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
        return itemStack;
    }

}
