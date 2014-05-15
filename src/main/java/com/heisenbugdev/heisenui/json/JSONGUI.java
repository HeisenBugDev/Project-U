package com.heisenbugdev.heisenui.json;

public class JSONGUI {

    //TODO: getters, setters
    //TODO: someway define multiple GUIs

    private String guiName;
    private int guiX;
    private int guiY;

    public String getName() {
        return guiName;
    }

    public void setGuiName(String name){
        this.guiName = name;
    }

    public int getGuiX() {
        return guiX;
    }

    public void setGuiX(int guiX) {
        this.guiX = guiX;
    }

    public int getGuiY() {
        return guiY;
    }

    public void setGuiY(int guiY) {
        this.guiY = guiY;
    }

}
