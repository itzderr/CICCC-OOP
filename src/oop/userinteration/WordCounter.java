package oop.userinteration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        // 1. read a text file
        // 2. command line arguments (program arguments)
        // 3. handle exceptions
        if (args.length != 1) {
            System.err.println("Invalid number of arguments. Please enter one city name.");
        } else {
            String filename = args[0];
            int counter = 0;
            try {
                File file = new File(filename + ".txt");
                Scanner in = new Scanner(file);

                // read text file by 'token' (word)
//            while (in.hasNext()) {
//                System.out.println(in.next());
//            }
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] words = line.split(" ");
                    counter += words.length;
                }

                System.out.println(filename + ".txt file contains " + counter + " words.");
            } catch (FileNotFoundException e) {
                // stdin : keyboard input - (System.in)
                // stdout : output (console) - (System.out)
                // stderr : display errors ('red' color) = (System.err)
                System.err.println(e.getLocalizedMessage());
            }
        }
    }
}
