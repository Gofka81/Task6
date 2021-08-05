package com.epam.rd.java.basic.practice6.part4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer>{

    private final List<Integer> list = new ArrayList<>();

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int firstBound, int secBound, boolean reversedOrder) {
        for(int i =firstBound; i<= secBound; i++){
            if(reversedOrder){
                list.add(0,i);
            }
            else{
                list.add(i);
            }
        }
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }
    
    private final class IteratorImpl implements Iterator<Integer> {

        private int indexNext;

        @Override
        public boolean hasNext() {
            return indexNext!=list.size();
        }

        @Override
        public Integer next() {
            int lastIndex =-1;
            if(indexNext>=list.size()){
                throw new NoSuchElementException();
            }
            lastIndex = indexNext;
            indexNext++;
            return list.get(lastIndex);
        }
        
    }

}
