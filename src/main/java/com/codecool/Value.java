package com.codecool;

import java.util.List;

public abstract class Value {

    private List<String> values;
    private boolean selectionType;

    public List<String> getInputPattern() {
        return this.values;
    }

    public boolean getSelectionType() {
        return this.selectionType;
    }
}