package com.epam.rd.java.basic.practice6.part2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2Test {
    List<Integer> arrayList;
    List<Integer> list;


    @Before
    public void setUp(){
        arrayList = new ArrayList<>();
        list = new LinkedList<>();
        for(int i = 0; i<10_000; i++){
            arrayList.add(i);
            list.add(i);
        }
    }

    @Test
    public void removeByIndex_ArrayFourTimesFaster(){
        long start1 = System.nanoTime();
        Part2.removeByIndex(arrayList,4);
        long finish1 = System.nanoTime();
        long arrlistTime = (finish1- start1)/1000_000;

        long start2 = System.nanoTime();
        Part2.removeByIndex(list,4);
        long finish2 = System.nanoTime();
        long listTime = (finish2 -start2)/1000_000;
        Assert.assertTrue((arrlistTime*4) < listTime);
    }

    @Test
    public void removeByIterator_LinkedListShouldBeFasterInMostCasesThanArrayList(){
        long start1 = System.nanoTime();
        Part2.removeByIterator(arrayList,4);
        long finish1 = System.nanoTime();
        long arrlistTime = (finish1- start1)/1000_000;

        long start2 = System.nanoTime();
        Part2.removeByIterator(list,4);
        long finish2 = System.nanoTime();
        long listTime = (finish2 -start2)/1000_000;
        Assert.assertTrue(arrlistTime > listTime);
    }
}