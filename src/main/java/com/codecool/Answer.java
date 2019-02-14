package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    private List<Value> valueList = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) {
        if("yes".equals(input)){
            return true;
        }
        else if(input.equals("no")){
            return false;
        }
        return false;
    }

    public void addValue(Value value) {
        this.valueList.add(value);
    }
}