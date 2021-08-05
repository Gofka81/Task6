package com.epam.rd.java.basic.practice6.part6;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Part6Test {
    ByteArrayOutputStream outContent;

    @After
    public void tearDown(){
        System.setOut(System.out);
    }

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintCorrectDuplicates() {
        String expected = "RAUGAJ\r\nNOSIB\r\nELAHW\r\n";
        Part6.main(new String[]{"-i", "part6.txt", "--task", "duplicates"});
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldPrintCorrectLength() {
        String expected = "chimpanzee ==> 10\r\nmongoose ==> 8\r\ntortoise ==> 8\r\n";
        Part6.main(new String[]{"--input", "part6.txt", "-t", "length"});
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldPrintCorrectFrequency() {
        String expected = "whale ==> 3\r\ncheetah ==> 4\r\nbison ==> 3\r\n";
        Part6.main(new String[]{"--input", "part6.txt", "--task", "frequency"});
        Assert.assertEquals(expected, outContent.toString());
    }
}
