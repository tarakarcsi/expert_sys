package com.codecool;

public class Main {

    public static void main(String[] args) {

        FactParser fp = new FactParser("src/main/resources/facts.xml");
        //fp.addFactsToRepository();
        RuleParser rp = new RuleParser("src/main/resources/rules.xml");
        rp.loadQuestions();
    }
}
