package com.codecool;

import java.util.Set;

public class Fact {
    private String id;
    private String description;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return this.description;
    }


    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setFactValueById(String id, boolean value){

    }

    public boolean getValueById(String id) {

    }

    public Set<String> getIdSet() {
        return idSet;
    }

}