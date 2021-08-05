package com.epam.rd.java.basic.practice6.part4;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RangeTest {

    static List<Integer> list;
    static Range range;

    @BeforeClass
    public static void setUp(){
        list = new ArrayList<>();
    }

    @After
    public void tearDown(){
        list.clear();
    }

    @Test
    public void shouldIterarte(){
        int start = 5;
        int finish = 15;
        for (int i =start; i<=finish; i++){
            list.add(i);
        }

        range = new Range(start,finish);
        Assert.assertEquals(range.getList(), list);
    }

    @Test
    public void shouldIterateInReverseOrder(){
        int start = 17;
        int finish = 3;
        for (int i =start; i>=finish; i--){
            list.add(i);
        }

        range = new Range(finish,start,true);
        Assert.assertEquals(range.getList(), list);
    }

    @Test
    public void testIterator(){
        boolean check = true;
        Iterator<Integer> iter =  range.iterator();
        int start = 3;
        int finish = 10;
        for (int i =start; i<=finish; i++){
            list.add(i);
        }

        range = new Range(start,finish);
        while (iter.hasNext() && check){
            int i=0;
            if(!iter.next().equals(list.get(i))){
                check = false;
            }
            i++;
        }
        Assert.assertTrue(check);
    }

}
