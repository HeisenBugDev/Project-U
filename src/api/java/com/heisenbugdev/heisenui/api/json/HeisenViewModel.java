package com.heisenbugdev.heisenui.api.json;

import com.heisenbugdev.heisenui.api.view.HeisenFrame;

import java.util.ArrayList;
import java.util.Map;

/**
 * Views are deserialized into here.
 */
public class HeisenViewModel
{

    private String identifier;
    private String controllerClass;
    private View view;
    private ArrayList<HeisenViewModel.Outlet> outlets;
    private ArrayList<HeisenViewModel.Target> targets;

    public String getIdentifier()
    {
        return identifier;
    }

    public String getControllerClass()
    {
        return controllerClass;
    }

    public View getView()
    {
        return view;
    }

    public ArrayList<Outlet> getOutlets()
    {
        return outlets;
    }

    public ArrayList<Target> getTargets()
    {
        return targets;
    }

    public static class View
    {
        private String identifier;
        private String type;
        private HeisenFrame frame;
        private int origin;
        private boolean hidden;
        private String textureLocation;
        private Map<String, Object> attributes;
        private ArrayList<View> subviews;

        public String getIdentifier()
        {
            return identifier;
        }

        public String getType()
        {
            return type;
        }

        public HeisenFrame getFrame()
        {
            return frame;
        }

        public int getOrigin()
        {
            return origin;
        }

        public boolean isHidden()
        {
            return hidden;
        }

        public String getTextureLocation() {
            return textureLocation;
        }

        public Map<String, Object> getAttributes()
        {
            return attributes;
        }

        public ArrayList<View> getSubviews()
        {
            return subviews;
        }
    }

    public static class Outlet
    {
        private String elementIdentifier;
        private String identifier;

        public String getElementIdentifier()
        {
            return elementIdentifier;
        }

        public String getIdentifier()
        {
            return identifier;
        }
    }

    public static class Target
    {
        private String elementIdentifier;
        private String identifier;
        private String action;

        public String getElementIdentifier()
        {
            return elementIdentifier;
        }

        public String getIdentifier()
        {
            return identifier;
        }

        public String getAction()
        {
            return action;
        }
    }

}
