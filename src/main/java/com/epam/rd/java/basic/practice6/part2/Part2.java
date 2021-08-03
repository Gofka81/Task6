package com.epam.rd.java.basic.practice6.part2;

import java.util.*;

public class Part2 {

    private static List<Integer> arrayList;
    private static List<Integer> list;

    public static void main(String[] args) {
        arrayList = new ArrayList<>();
        list = new LinkedList<>();
        fillLists();
        System.out.println("ArrayList#Index: "+removeByIndex(arrayList,4 ) +"ms");
        System.out.println("LinkedList#Index: "+removeByIndex(list,4 ) +"ms");
        fillLists();
        System.out.println("ArrayList#Iterator: "+removeByIterator(arrayList,4 ) +"ms");
        System.out.println("LinkedList#Iterator: "+removeByIterator(list,4 ) +"ms");
    }

    public static void fillLists(){
        for(int i = 0; i<10_000; i++){
            arrayList.add(i);
            list.add(i);
        }
    }

    public static long removeByIndex(final List<Integer> list, final int k) {
        long time = System.nanoTime();
        int index = k-1;

        while (list.size()-1 > 0) {
            list.remove(index);
            index += k - 1;
            if (index > list.size() - 1) {
                index %= list.size();
            }
        }

        return (System.nanoTime()-time)/1000_000;
    }



    public static long removeByIterator(final List<Integer> list, int k) {
        long time1 = System.nanoTime();
        Iterator<Integer> iterator =  list.iterator();

        while (list.size()-1>0){
            for(int i =0; i<k; i++) {
                if (!iterator.hasNext()) {
                    iterator = list.iterator();
                }
                iterator.next();
            }
            iterator.remove();
        }

        return (System.nanoTime()-time1)/1000_000;
    }

}
