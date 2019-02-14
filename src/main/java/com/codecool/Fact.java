package com.codecool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String id;
    private String description;
    private Map<String, Boolean> evalMap;
    private Set<String> idSet;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return this.description;
    }



    public Map<String, Boolean> getEvalMap() {
        return this.evalMap;
    }

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.evalMap = new HashMap<>();
    }

    public void setFactValueById(String id, boolean value){
        this.evalMap.put(id, value);
    }

    /*public boolean getValueById(String id) {

    }*/

    public Set<String> getIdSet() {
        return this.idSet;
    }

}