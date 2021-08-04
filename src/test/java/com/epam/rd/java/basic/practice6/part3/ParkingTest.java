package com.epam.rd.java.basic.practice6.part3;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParkingTest {
    static Parking p;

    @BeforeClass
    public static void setUp(){
        p = new Parking(4);
    }

    @Before
    public void setUpSystemOut(){
        p.depart(0);
        p.depart(1);
        p.depart(2);
        p.depart(3);
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown(){
        System.setOut(System.out);
    }

    @Test
    public void shouldShiftRightWhenArriveToOccupiedPlace(){
        p.arrive(2);
        p.arrive(2);
        Assert.assertTrue(!p.isFreeHere(2)&&!p.isFreeHere(3));
    }

    @Test
    public void shouldShiftToTheStartWhenAllPlacesOnTheRightAreOccupied(){
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        Assert.assertFalse(p.isFreeHere(0));
    }

    @Test
    public void shouldReturnFalseAsAllParkingSlotsAreFull(){
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        Assert.assertFalse(p.arrive(1));
    }

    @Test
    public void shouldDepartFromParking(){
        p.arrive(3);
        Assert.assertTrue(p.depart(3)&&p.isFreeHere(3));
    }

    @Test
    public void shouldntDepartFromEmptyParking(){
        Assert.assertFalse(p.depart(0));
    }

    @Test
    public void shouldReturnTrueAsThereIsFreeSlot(){
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        p.depart(0);
        Assert.assertTrue(p.isFreeSlots());
    }

}