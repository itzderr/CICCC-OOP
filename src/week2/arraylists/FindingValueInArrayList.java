package week2.arraylists;

import java.util.ArrayList;
import java.util.Scanner;

public class FindingValueInArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();                     // declare the ArrayList of Integer
        int max = 50;
        int min = 1;
        for (int i = 0; i < 10; i++){
            double random_double = Math.random() * (max - min + 1) + min;
            int random_int = (int)Math.round(random_double);
            numList.add(random_int);
        }
        System.out.println("ArrayList: " + numList);
        System.out.print("Value to find: ");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        for (int i = 0; i < numList.size(); i++){
            if (numList.get(i) == input){
                System.out.println(numList.get(i) + " is in the ArrayList.");
            }
        }
    }
}

