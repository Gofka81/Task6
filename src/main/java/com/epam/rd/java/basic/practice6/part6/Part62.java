package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Part62 {

    private Part62(){}

    public static void start(String content){
        String[] words = content.split("[ \r\n]");
        Stream<String> stream = Arrays.stream(words);
        stream.sorted(Comparator.comparing(String::length).reversed()).limit(3).forEach((x-> System.out.println(x+" ==> "+x.length())));
    }

}
