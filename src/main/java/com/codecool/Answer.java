package com.codecool;

import java.util.List;

public class Answer {

    private List<Value> valueList;

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