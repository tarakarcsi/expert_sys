package com.codecool;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Arrays;
import java.util.List;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;
    private NodeList nodeList;

    public RuleParser(String xmlPath) {
        loadXmlDocument(xmlPath);
        this.ruleRepository = new RuleRepository();
        this.nodeList = doc.getElementsByTagName("Rule");

    }

    public void loadQuestions(){
        for(int i = 0;i < nodeList.getLength(); i++){
            Node ruleNode = nodeList.item(i);
            Element ruleElement = (Element) ruleNode;
            String id = ruleElement.getAttribute("id");
            String questionText = ruleElement.getElementsByTagName("Question").item(0).getTextContent();
            Answer answer = loadAnswers(ruleElement);
            Question question = new Question(id,questionText,answer);

            this.ruleRepository.addQuestion(question);
        }
        //reading the questions part and making Question objects
        //need: iterate through the nodelist: declare rule id(single/multi and question textcontent
        //make question object line Question q = new Question(id, text)
    }

    public Answer loadAnswers(Element element) { //reading the answers part and making Answer objects

        Answer answer = new Answer();
        NodeList answerList = element.getElementsByTagName("Selection");

        for(int i = 0; i < answerList.getLength(); i++) {
            Node answerNode = answerList.item(i);

            if(answerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element answerElement = (Element) answerNode;

                Element valueNode = (Element) answerNode.getChildNodes().item(0);
                boolean answerType = Boolean.valueOf(answerElement.getAttribute("value"));

                Value value;

                if(valueNode.getNodeName().equals("SingleValue")) {
                    String param = valueNode.getAttribute("value");
                    value = new SingleValue(param, answerType);
                }else {
                    List<String> parameters = Arrays.asList(valueNode.getAttribute("value").split(","));
                    value = new MultipleValue(parameters, answerType);
                }
                answer.addValue(value);
            }
        }
        return answer;
    }

}


