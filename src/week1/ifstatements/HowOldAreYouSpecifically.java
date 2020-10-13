package week1.ifstatements;

import java.util.Scanner;

public class HowOldAreYouSpecifically {
    public static void main(String[] args) {
        Scanner nameObject = new Scanner(System.in);  // Scanner object for name
        System.out.println("Hello. What is your name? (Sorry, I keep forgetting.)");

        String userName = nameObject.nextLine();  // Read user input(string)

        System.out.println("Ok, " + userName + ", how old are you?");

        Scanner ageObject = new Scanner(System.in);
        int userAge = ageObject.nextInt();

        if (userAge < 16){
            System.out.println("You can't drive.");
        } else if(userAge == 16 || userAge == 17) {
            System.out.println("You can drive but not vote. " + userName + ".");
        } else if (userAge >=18 || userAge <= 24){
            System.out.println("You can vote but not rent a car. " + userName + ".");
        } else{
            System.out.println("You can oo pretty much anything. " + userName + ".");
        }


    }
}
