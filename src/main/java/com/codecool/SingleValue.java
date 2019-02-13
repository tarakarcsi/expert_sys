package com.codecool;

public class SingleValue extends Value{
    private String param;
    private boolean sType;

    public SingleValue(String param,boolean selectionType) {
        this.param = param;
        this.sType = sType;
    }

    public String getParam() {
        return param;
    }

    public boolean getSelectionType() {
        return sType;
    }
}