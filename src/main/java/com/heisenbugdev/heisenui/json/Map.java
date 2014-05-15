package com.heisenbugdev.heisenui.json;

import java.util.List;

public class Map {

    //TODO: Getters and Settters

    private int identifier;
    private String targets;
    private String controllerClass;
    private int order;

    public static class elements {
        private String identifier;
        private int type;
        private List<frame> frame;
        private int origin;
        private boolean hidden;
        private List<label> text;
    }

    public static class frame {
        private int x;
        private int y;
        private int width;
        private int height;
    }

    public static class label {
        private String content;
        private int size;
    }

    public static class outlets {
        private String elementIdentifier;
        private String identifier;
    }

    public static class targets {
        private String elementIdentifier;
        private String identifier;
        private String action;
    }

}
