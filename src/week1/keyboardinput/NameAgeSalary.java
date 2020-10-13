package week1.keyboardinput;

import java.util.Scanner;

public class NameAgeSalary {
    public static void main(String[] args) {
        Scanner nameObject = new Scanner(System.in);  // Scanner object for name
        System.out.println("Hello. What is your name?");

        String userName = nameObject.nextLine();  // Read user input(string)

        Scanner ageObject = new Scanner(System.in); // Scanner object for age
        System.out.println("Hi, " + userName + "! How old are you?");
        int userAge = ageObject.nextInt();  // Read user input(numerical)

        System.out.println("So you're " + userAge + " ,eh? That's not old at all!");
        System.out.println("How much do you make, " + userName + "?");

        Scanner salaryObject = new Scanner (System.in);  // Scanner object for salary
        double userSalary = salaryObject.nextDouble();


        System.out.println(userSalary + "! I hope that's per hour and not per year! LOL!");

    }
}
