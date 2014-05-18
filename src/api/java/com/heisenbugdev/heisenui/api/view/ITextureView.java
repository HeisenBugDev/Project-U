package com.heisenbugdev.heisenui.api.view;

import com.heisenbugdev.heisenui.api.view.IView;
import net.minecraft.util.ResourceLocation;

public interface ITextureView extends IView
{

    public ResourceLocation texture();
    public void setTexture(ResourceLocation texture);
}
