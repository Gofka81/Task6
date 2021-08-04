package com.epam.rd.java.basic.practice6.part5;

public class Part5 {
    
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(new Integer[]{4,1,5,7,3,6,1,3,5,7,8,9,3});
        tree.print();
        tree.remove(9);
        tree.remove(7);
        tree.remove(5);
        System.out.println();
        System.out.println();
        tree.print();
    }
    
}
