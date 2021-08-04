package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {

	public static void main(String[] args) {
		System.setIn(new ByteArrayInputStream(
				"asd 43 asdf asd 43^434 asdf^kasdf asdf stop asdf^stop"
				.replace("^",System.lineSeparator()).getBytes(StandardCharsets.UTF_8)));
		WordContainer.main(null);

	}


}
