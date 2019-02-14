package  com.codecool;

import java.util.Iterator;
import java.util.List;

public class RuleRepository {

    private List<Question> questions;
    private Iterator<Question> questionIterator;

    public List<Question> getQuestions() {
        return questions;
    }


    public Iterator<Question> getQuestionIterator() {
        return questionIterator;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public class ruleIterator implements Iterator{

        private int index;

        @Override
        public boolean hasNext() {
            return index < questions.size();
        }

        @Override
        public Object next() {
            if(hasNext()) {
                return questions.get(index++);
            }else
                return null;

        }
    }
}