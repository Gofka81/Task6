package com.epam.rd.java.basic.practice6.part6;

import com.epam.rd.java.basic.practice6.part1.Word;

import java.util.*;
import java.util.stream.Stream;

public class Part61{

    private Part61(){}

    private static Set<Word> wordsSet;

    public static void start(String content){
        wordsSet = new LinkedHashSet<>();
        fill(content);
        Stream<Word> stream = wordsSet.stream();
        stream.sorted(Comparator.comparing(Word::getFrequency).reversed()).limit(3).sorted(Comparator.comparing(Word::getContent)).forEach(x-> System.out.println(x.getContent() +" ==> "+ x.getFrequency()));
    }

    public static void fill (String content){
        String[] words = content.split("[ \n\r]");
        for(String word: words){
            Stream<String> stream = Arrays.stream(words);
            if(word.equals("")){
                continue;
            }
            if(!isHere(word))
                wordsSet.add(new Word(word, (int) stream.filter(x -> (x.equals(word))).count()));
        }
    }

    public static boolean isHere(String o){
        Stream<Word> stream = wordsSet.stream();
        return stream.anyMatch(x->x.getContent().equals(o));
    }
}
