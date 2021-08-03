package com.epam.rd.java.basic.practice6.part3;

public class Part3 {
    
    public static void main(String[] args) {
        Parking t = new Parking(10);
        t.arrive(4);
        t.arrive(4);
        t.arrive(4);
        t.arrive(4);
        t.arrive(4);
        t.arrive(4);
        t.print();
        System.out.println();
        t.depart(1);
        t.depart(5);
        t.depart(0);
        t.print();
    }

}
