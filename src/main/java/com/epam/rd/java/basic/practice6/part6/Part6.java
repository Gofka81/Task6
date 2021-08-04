package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part6 {

    public static void main(String[] args) {
        String filePath;
        String task;
        if(args[0].equals("-i") || args[0].equals("--input") && args[2].equals("-t") || args[2].equals("--task")){
            filePath = args[1];
            task = args[3];
        }
        else {
            filePath = args[3];
            task = args[1];
        }

        switch (task){
            case "frequency":
                Part61.start(inputText(filePath));
                break;
            case "length":
                Part62.start(inputText(filePath));
                break;
            case "duplicates":
                Part63.start(inputText(filePath));
                break;
            default:
        }
    }

    public static String inputText(String fileName){
        Logger logger = Logger.getAnonymousLogger();
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append(System.lineSeparator());
            }
            sc.close();
            return sb.toString().trim();
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "IOException");
        }
        return sb.toString();
    }
    
}
