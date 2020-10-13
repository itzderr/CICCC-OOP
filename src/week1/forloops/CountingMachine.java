package week1.forloops;

import java.util.Scanner;

public class CountingMachine {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Scanner object
        System.out.print("Count to: ");
        int count = myObj.nextInt();

        for (int i = 0; i <= count; i++){
            System.out.print(i + " ");
        }

    }
}
