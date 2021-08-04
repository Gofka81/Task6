package com.epam.rd.java.basic.practice6.part1;

import java.util.*;
import java.util.stream.Stream;

public class WordContainer {

	private  Set<Word> wordSet = new TreeSet<>();

	public static void main(String[] args) {
		WordContainer container = new WordContainer();
		container.fill(container.input());
		container.printSet();
	}

	public String input(){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String buffer;
		while (sc.hasNextLine()) {
			buffer = sc.nextLine();
			if(buffer.matches("stop")){
				break;
			}
			sb.append(buffer).append(System.lineSeparator());
		}
		sc.close();
		return sb.toString().replaceAll("stop.*"," ").trim();
	}


	public void fill (String content){
		String[] words = content.split("[ \n\r]");
		for(String word: words){
			Stream<String> stream = Arrays.stream(words);
			if(word.equals("")){
				continue;
			}
			wordSet.add(new Word(word, (int) stream.filter(x -> (x.equals(word))).count()));
		}
	}

	public void printSet(){
		for(Word word: wordSet){
			System.out.println(word.getContent() + " : "+ word.getFrequency());
		}
	}
}