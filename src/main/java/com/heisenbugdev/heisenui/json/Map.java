package com.heisenbugdev.heisenui.json;

import java.util.List;

public class Map
{

    private int identifier;
    private String targets;
    private String controllerClass;
    private int order;

    public int getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(int identifier)
    {
        this.identifier = identifier;
    }

    public String getTargets()
    {
        return targets;
    }

    public void setTargets(String targets)
    {
        this.targets = targets;
    }

    public String getControllerClass()
    {
        return controllerClass;
    }

    public void setControllerClass(String controllerClass)
    {
        this.controllerClass = controllerClass;
    }

    public int getOrder()
    {
        return order;
    }

    public void setOrder(int order)
    {
        this.order = order;
    }

    public static class elements
    {
        private String identifier;
        private int type;
        private List<frame> frame;
        private int origin;
        private boolean hidden;
        private List<label> text;

        public String getIdentifier()
        {
            return identifier;
        }

        public void setIdentifier(String identifier)
        {
            this.identifier = identifier;
        }

        public int getType()
        {
            return type;
        }

        public void setType(int type)
        {
            this.type = type;
        }

        public List<Map.frame> getFrame()
        {
            return frame;
        }

        public void setFrame(List<Map.frame> frame)
        {
            this.frame = frame;
        }

        public int getOrigin()
        {
            return origin;
        }

        public void setOrigin(int origin)
        {
            this.origin = origin;
        }

        public boolean isHidden()
        {
            return hidden;
        }

        public void setHidden(boolean hidden)
        {
            this.hidden = hidden;
        }

        public List<label> getText()
        {
            return text;
        }

        public void setText(List<label> text)
        {
            this.text = text;
        }
    }

    public static class frame
    {
        private int x;
        private int y;
        private int width;
        private int height;

        public int getX()
        {
            return x;
        }

        public void setX(int x)
        {
            this.x = x;
        }

        public int getY()
        {
            return y;
        }

        public void setY(int y)
        {
            this.y = y;
        }

        public int getWidth()
        {
            return width;
        }

        public void setWidth(int width)
        {
            this.width = width;
        }

        public int getHeight()
        {
            return height;
        }

        public void setHeight(int height)
        {
            this.height = height;
        }
    }

    public static class label
    {
        private String content;
        private int size;

        public String getContent()
        {
            return content;
        }

        public void setContent(String content)
        {
            this.content = content;
        }

        public int getSize()
        {
            return size;
        }

        public void setSize(int size)
        {
            this.size = size;
        }
    }

    public static class outlets
    {
        private String elementIdentifier;
        private String identifier;

        public String getElementIdentifier()
        {
            return elementIdentifier;
        }

        public void setElementIdentifier(String elementIdentifier)
        {
            this.elementIdentifier = elementIdentifier;
        }

        public String getIdentifier()
        {
            return identifier;
        }

        public void setIdentifier(String identifier)
        {
            this.identifier = identifier;
        }
    }

    public static class targets
    {
        private String elementIdentifier;
        private String identifier;
        private String action;

        public String getElementIdentifier()
        {
            return elementIdentifier;
        }

        public void setElementIdentifier(String elementIdentifier)
        {
            this.elementIdentifier = elementIdentifier;
        }

        public String getIdentifier()
        {
            return identifier;
        }

        public void setIdentifier(String identifier)
        {
            this.identifier = identifier;
        }

        public String getAction()
        {
            return action;
        }

        public void setAction(String action)
        {
            this.action = action;
        }
    }

}
