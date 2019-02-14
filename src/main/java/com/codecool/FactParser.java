package com.codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {

    private FactRepository factRepository;
    private NodeList nodeList;

    public FactParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.factRepository = new FactRepository();
        this.nodeList = doc.getElementsByTagName("Fact");
        addFactsToRepository();
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }


    public void addFactsToRepository() { //creating fact objects from the xml
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node factNode = nodeList.item(i);
            Element factElement = (Element) factNode;
            String id = factElement.getAttribute("id");
            Node descriptionNode = factElement.getElementsByTagName("Description").item(0);
            String description = ((Element)descriptionNode).getAttribute("value");

            Fact fact = new Fact(id, description);
            getEvalMap(factElement, fact);

            this.factRepository.addFact(fact);

        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void getEvalMap(Element tempElement, Fact fact) { // parsing the Evals part of the xml and putting them into Maps

        Element evalsNode = (Element) tempElement.getElementsByTagName("Evals").item(0); // root element: <Evals>
        NodeList evalNodes = evalsNode.getElementsByTagName("Eval");             //list of Eval nodes

        for(int i = 0; i < evalNodes.getLength(); i++){

            Element evaluation = (Element) evalNodes.item(i);

            String id = evaluation.getAttribute("id");
            String value = evaluation.getTextContent();

            fact.setFactValueById(id, Boolean.valueOf(value));
        }
    }
}