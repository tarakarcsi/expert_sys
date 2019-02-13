package com.codecool;

import java.util.List;

public class MultipleValue extends Value{

    private List<String> mValue;
    private boolean sType;

    public MultipleValue(List<String> mValue,boolean sType){
        this.mValue = mValue;
        this.sType = sType;
    }

    public List<String> getmValue() {
        return mValue;
    }

    public boolean sType() {
        return sType;
    }
}