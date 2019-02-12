package com.codecool;

import java.util.Iterator;
import java.util.List;

public class FactRepository {

    private List<Fact> factList;
    private Iterator<Fact> factIterator;


    public List<Fact> getFactList() {
        return factList;
    }

    public void addFact(Fact fact) {
        factList.add(fact);
    }
    public class FactIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {

            return index < factList.size();
        }

        @Override
        public Object next() {
            if(hasNext()) {
                return factList.get(index++);
            }
            else
                return null;
        }
    }
}