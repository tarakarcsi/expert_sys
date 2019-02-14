package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {

    private List<Fact> factList;
    private Iterator<Fact> factIterator;


    public FactRepository() {
        this.factList = new ArrayList<>();
        this.factIterator = new FactIterator();
    }

    public List<Fact> getFactList() {
        return this.factList;
    }

    public Iterator<Fact> getFactIterator() {
        return this.factIterator;
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