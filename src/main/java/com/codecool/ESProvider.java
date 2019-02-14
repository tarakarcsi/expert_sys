package com.codecool;

import java.util.*;

public class ESProvider {

    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> answers;
    private Answer answer = new Answer();

    public Map<String, Boolean> getAnswer() {
        return answers;
    }

    public ESProvider (FactParser factParser,RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void collectAnswer(){

        String input;
        answers = new HashMap<>();

        while(ruleParser.getRuleRepository().getQuestionIterator().hasNext()){
            int i = 0;
            for(Question question : ruleParser.getRuleRepository().getQuestions()){
                Question currentQ = ruleParser.getRuleRepository().getQuestionIterator().next();
                System.out.println(currentQ.getQuestion() + "Yes or No");
                input = this.getInput();
                while(!isValid(input)) {
                    System.out.println(ruleParser.getRuleRepository().getQuestions().get(i).getQuestion() + "Yes or No");
                    input = this.getInput();
                }
                i++;
                answers.put(question.getId(), answer.evaluateAnswerByInput(input));
            }
        }
    }

    public String evaluate(){

    }

    public boolean getAnswerByQuestion(String questionId){
        return answers.get(questionId);
    }

    public boolean isValid(String answer){
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
            return true;
        } else {
            return false;
        }
    }
}