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
        System.out.println(ruleParser.getRuleRepository());

        while(ruleParser.getRuleRepository().getQuestionIterator().hasNext()){
            int i = 0;
            for(Question question : ruleParser.getRuleRepository().getQuestions()){
                Question currentQ = ruleParser.getRuleRepository().getQuestionIterator().next();
                System.out.println(currentQ.getQuestion() + "yes or no");
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
        // If it finds one then the answer it returns will be the description of the Fact otherwise null.
        String result = null;
        Map<Fact, Map<String, Boolean>> evalMap = new HashMap<>();

        for(Fact fact : factParser.getFactRepository().getFactList()) {
            evalMap.put(fact, fact.getEvalMap());
        }

        for(Map.Entry<Fact, Map<String, Boolean>> facts : evalMap.entrySet()) {
            if(facts.getValue().equals(answers)) {
                result = facts.getKey().getDescription();
            }
        }
        return result;
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