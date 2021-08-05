package com.epam.rd.java.basic.practice6.part1;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;


public class WordContainerTest {

    static Set<Word> wordSet;
    static WordContainer container;

    @BeforeClass
    public static void initAll(){
        container = new WordContainer();
    }

    @Test
    public void shouldReturnStringTillStop(){
        InputStream std = System.in;
        System.setIn(new ByteArrayInputStream(
                "asd 43 asdf asd 43^434 asdf^kasdf asdf stop asdf^stop"
                        .replace("^",System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        String expected = "asd 43 asdf asd 43\r\n434 asdf\r\nkasdf asdf";
        String iput = container.input();
        System.setIn(std);
        Assert.assertEquals(iput, expected);
    }

    @Test
    public void shouldFillSetCorrectly(){
        Set<Word> wordSet1 = new TreeSet<>();
        wordSet1.add(new Word("asdf",3));
        wordSet1.add(new Word("43",2));
        wordSet1.add(new Word("asd",2));
        wordSet1.add(new Word("434",1));
        wordSet1.add(new Word("kasdf",1));


        InputStream std = System.in;
        System.setIn(new ByteArrayInputStream(
                "asd 43 asdf asd 43^434 asdf^kasdf asdf stop asdf^stop"
                        .replace("^",System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
        String expected = "asd 43 asdf asd 43\r\n434 asdf\r\nkasdf asdf";
        String input = container.input();
        System.setIn(std);
        container.fill(input);
        wordSet = container.getWordSet();
        wordSet1.removeAll(wordSet);
        Assert.assertTrue(wordSet1.isEmpty());
    }

}
