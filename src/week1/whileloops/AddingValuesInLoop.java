package week1.whileloops;

import java.util.Scanner;



public class AddingValuesInLoop {
    public static void main(String[] args) {

        System.out.println("I will add up the numbers you give me.");
        System.out.print("Number: " );
        Scanner numberObject = new Scanner(System.in);
        int number = numberObject.nextInt();
        int total = 0;

        while (number != 0){
            total = total + (number);
            System.out.println("The total so far is " + total);

            Scanner scan = new Scanner(System.in);
            System.out.print("Number: " );
            int number_ = scan.nextInt();
            number = number_;
        }

    }
}
