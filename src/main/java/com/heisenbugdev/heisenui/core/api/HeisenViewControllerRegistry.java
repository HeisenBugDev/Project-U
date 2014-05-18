package com.heisenbugdev.heisenui.core.api;

import com.heisenbugdev.heisenui.api.IViewControllerRegistry;
import com.heisenbugdev.heisenui.api.view.HeisenViewController;
import com.heisenbugdev.heisenui.api.json.HeisenViewModel;
import com.heisenbugdev.heisenui.json.JSONHandler;
import com.heisenbugdev.heisenui.logger.HeisenLogger;
import cpw.mods.fml.common.ModContainer;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public enum HeisenViewControllerRegistry implements IViewControllerRegistry
{
    INSTANCE;

    private HashMap<String, ViewControllerEntry> registry;

    private HeisenViewControllerRegistry()
    {
        registry = new HashMap<String, ViewControllerEntry>();
    }

    @Override
    public void registerJsonView(String jsonPath, ModContainer mod)
    {
        InputStream stream = this.getClass().getResourceAsStream(jsonPath);
        this.registerJsonView(stream, mod);
    }

    @Override
    public void registerJsonView(InputStream jsonStream, ModContainer mod)
    {
        try
        {
            HeisenViewModel model = JSONHandler.jsonLoader(jsonStream);
            HeisenViewController controller = new HeisenViewController(model, null);
            String modId = mod.getModId();

            if (this.registry.containsKey(model.getIdentifier()))
            {
                // TODO: ERROR
            }
            else
            {
                ViewControllerEntry entry = new ViewControllerEntry(controller, modId);
                registry.put(model.getIdentifier(), entry);
            }
        }
        catch (IOException e)
        {
            HeisenLogger.warn("Could not register JSON view because it could not be read.");
            HeisenLogger.trace(e);
        }
    }

    private static class ViewControllerEntry
    {
        public final HeisenViewController controller;
        public final String modId;

        public ViewControllerEntry(HeisenViewController controller, String modId)
        {
            this.controller = controller;
            this.modId = modId;
        }
    }
}
