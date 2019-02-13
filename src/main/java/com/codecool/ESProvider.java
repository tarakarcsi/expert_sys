package com.codecool;

import java.util.*;

public class ESProvider {

    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> answer;
    private Answer answer = new Answer();

    public Map<String, Boolean> getAnswer() {
        return answer;
    }

    public void (FactParser factParser,RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void collectAnswer(){

    }

    public List<Fact> evaluate(){

    }

    public boolean getAnswerByQuestion(String questionId){
        return answer.get(questionId);
    }

    public boolean isValid(String answer){
    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
        return true;
        } else {
            return false;
        }

    }

}