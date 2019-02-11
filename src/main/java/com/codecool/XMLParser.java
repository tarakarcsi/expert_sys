package com.codecool;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

    public class XMLParser {

        public void loadXmlDocument(String pathName) {
            try {

                File fXmlFile = new File(pathName);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                NodeList nList = doc.getElementsByTagName("facts");

                System.out.println("----------------------------");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    System.out.println("\nCurrent Element :" + nNode.getNodeName());

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        System.out.println("Car id     : " + eElement.getAttribute("id"));
                        System.out.println("Family     : " + eElement.getElementsByTagName("family").item(0).getTextContent());
                        System.out.println("Money      : " + eElement.getElementsByTagName("money").item(0).getTextContent());
                        System.out.println("Comfort    : " + eElement.getElementsByTagName("comfort").item(0).getTextContent());
                        System.out.println("Luxury     : " + eElement.getElementsByTagName("luxury").item(0).getTextContent());
                        System.out.println("Speed      : " + eElement.getElementsByTagName("speed").item(0).getTextContent());
                        System.out.println("Consumption: " + eElement.getElementsByTagName("consumption").item(0).getTextContent());

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

