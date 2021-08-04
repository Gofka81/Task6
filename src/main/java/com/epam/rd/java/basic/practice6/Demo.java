package com.epam.rd.java.basic.practice6;

import com.epam.rd.java.basic.practice6.part6.Part6;

public class Demo {

	public static void main(String[] args) {
		System.out.println("~~~~~~~~~~~~Part6");

		Part6.main(new String[] {"--input", "part6.txt", "--task", "frequency"});

		Part6.main(new String[] {"--input", "part6.txt", "--task", "length"});

		Part6.main(new String[] {"--input", "part6.txt", "--task", "duplicates"});
	}

}
