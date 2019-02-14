package com.codecool;

public class Main {

    public static void main(String[] args) {

        FactParser factParser = new FactParser("src/main/resources/facts.xml");
        RuleParser ruleParser = new RuleParser("src/main/resources/rules.xml");
        ESProvider esp = new ESProvider(factParser, ruleParser);

        esp.collectAnswer();
        System.out.println("We recommend u the " + esp.evaluate());
    }
}
