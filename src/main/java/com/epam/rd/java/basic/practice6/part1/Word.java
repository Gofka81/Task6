package com.epam.rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

	private String content;
	
	private int frequency;

	public Word(String content, int frequency){
	    this.content = content;
	    this.frequency = frequency;
    }

    @Override
    public boolean equals(Object obj) {
	    if(!(obj instanceof Word)){
	        return false;
        }
	    else {
	        Word word = (Word) obj;
            return (this.content.equalsIgnoreCase(word.content));
        }
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = hashCode * this.content.hashCode();
        return hashCode;
    }

    @Override
    public int compareTo(Word o) {
        if (this.getFrequency() < o.getFrequency())
            return 1;

        else if (this.getFrequency() > o.getFrequency())
            return -1;

        else
            return this.getContent().compareTo(o.getContent());
    }

    public int getFrequency() {
        return frequency;
    }

    public String getContent() {
        return content;
    }
}
