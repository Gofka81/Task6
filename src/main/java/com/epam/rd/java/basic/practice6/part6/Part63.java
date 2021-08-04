package com.epam.rd.java.basic.practice6.part6;

import java.util.Arrays;
import java.util.stream.Stream;

public class Part63{
    private Part63(){}

    public static void start(String content){
        int count =0;
        String[] words = content.split("[ \r\n]");
        StringBuilder sb = new StringBuilder();
        for(String s: words){
            if(count ==3){
                break;
            }
            sb.append(s);
            Stream<String> stream = Arrays.stream(words);
            if(stream.filter(x->x.length()>0).filter(x -> (x.equals(s))).count() > 1){
                System.out.println(sb.reverse().toString().toUpperCase());
                count++;
            }
            sb.delete(0,s.length());
        }
    }
}
