package week1.keyboardinput;

import java.util.Scanner;

public class AgeInFiveYears {
    public static void main(String[] args) {
        Scanner nameObject = new Scanner(System.in);  // Scanner object for name
        System.out.println("Hello. What is your name?");

        String userName = nameObject.nextLine();  // Read user input(string)
        System.out.println("Hi, " + userName + "How old are you?");

        Scanner ageObject = new Scanner(System.in);
        int userAge = ageObject.nextInt();

        int future = userAge + 5;
        int past = userAge - 5;
        System.out.println("Did you know that in five years you will be " + future
        + " years old? And five years ago you were " + past + "! Imagine that!");
    }
}
