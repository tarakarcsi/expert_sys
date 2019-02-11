package com.codecool;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public abstract class XMLParser {

    protected Document doc;


    public void loadXmlDocument(String pathName) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.parse(pathName);
            this.doc.getDocumentElement().normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

