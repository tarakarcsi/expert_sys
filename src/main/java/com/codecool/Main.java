package com.codecool;

public class Main {

    public static void main(String[] args) {
        XMLParser load = new XMLParser();
        load.loadXmlDocument("src/main/resources/facts.xml");
    }
}
