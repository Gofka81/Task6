package com.epam.rd.java.basic.practice6.part5;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeTest {
    static Tree<Integer> tree;


    @BeforeClass
    public static void setUp(){
        tree = new Tree<>();
    }

    @After
    public void tearDown(){
        tree.setRoot(null);
    }

    @Test
    public void shouldAdd(){
        tree.add(2);
        tree.add(3);
        tree.add(1);
        Assert.assertEquals(2, (int) tree.getRootData());
    }

    @Test
    public void shouldRemove(){
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.remove(2);
        tree.remove(1);
        Assert.assertEquals(3,(int) tree.getRootData());
    }

    @Test
    public void shouldAddArray(){
        tree.add(5);
        tree.add(new Integer[]{2,3,4,6,7});
        tree.remove(2);
        tree.remove(5);
        Assert.assertEquals(6, (int) tree.getRootData());
    }
    
}
