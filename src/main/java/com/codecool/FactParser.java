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

    }


    public void addFactsToRepository() { //creating fact objects from the xml
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node factNode = nodeList.item(i);
            Element factElement = (Element) factNode;
            String id = factElement.getAttribute("id");
            Node descriptionNode = factElement.getElementsByTagName("Description").item(0);
            String description = ((Element)descriptionNode).getAttribute("value");

            Fact fact = new Fact(id, description);
        }
    }

    public void getEvalMap(Element tempElement, Fact fact) { // parsing the Evals part of the xml and putting them into Maps

        Element evalsNode = (Element) tempElement.getElementsByTagName("Evals").item(0); // root element: <Evals>
        NodeList evalNodes = evalsNode.getElementsByTagName("Eval");             //list of Eval nodes

        for(int i = 0; i < evalNodes.getLength(); i++){


        }
    }
}