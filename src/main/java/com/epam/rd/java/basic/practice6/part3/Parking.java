package com.epam.rd.java.basic.practice6.part3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Parking {

    private int[] parkingSlots;

    public Parking(int capacity) {
         parkingSlots = new int[capacity];
    }

    public boolean arrive(int k){
         if(k < 0 || k > parkingSlots.length-1){
             throw new IllegalArgumentException("The number is less than 0 or bigger than capacity" );
         }
         if(!isFreeSlots()){
             return false;
         }
         parking(k);
         return true;
    }

    public boolean depart(int k){
         if(k < 0 || k > parkingSlots.length-1){
             throw new IllegalArgumentException("The number is less than 0 or bigger than capacity");
         }

         if(isFreeHere(k)){
             return false;
         }
         setParkStats(k);
         return true;
    }
    
    public void print() {
         IntStream stream = Arrays.stream(parkingSlots);
         stream.forEach(System.out::print);
    }

    private boolean isFreeSlots(){
        IntStream stream = Arrays.stream(parkingSlots);
         return stream.anyMatch(x->x ==0);
    }

    private boolean isFreeHere(int k){
        return 0 == getParkStats(k) ;
    }

    private void setParkStats(int k){
         parkingSlots[k] = parkingSlots[k] ==0? 1 : 0;
    }
    private int getParkStats(int k){
        return parkingSlots[k];
    }

    private void parking(int k){
        for(int i =k; i < parkingSlots.length; i++){
            if(isFreeHere(i)){
                setParkStats(i);
                return;
            }
        }

        for (int i =0; i < k; i++){
            if(isFreeHere(i)){
                setParkStats(i);
                break;
            }
        }
    }
}
