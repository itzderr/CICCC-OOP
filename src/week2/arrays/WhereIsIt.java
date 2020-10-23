package week2.arrays;

import java.util.Scanner;

public class WhereIsIt {
    public static void main(String[] args) {
        int max = 50;
        int min = 1;
        int[] arr = new int[10];
        System.out.print("Array: ");
        for (int i = 0; i < arr.length ; i++){
            double random_double = Math.random() * (max - min + 1) + min;
            int random_int = (int)Math.round(random_double);
            arr[i] = random_int;
            System.out.print(arr[i] + " ");
        }
        // take user input
        System.out.print("\nValue to find: ");
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        int count = 0;
        for (int i = 0; i < arr.length ; i++){
            if (arr[i] == value){
                System.out.println(value + " is in slot " + i + " .");
                count += 1;
            }
        }
        if(count > 0){
            System.exit(0);
        }else {
            System.out.println(value + " is not in the array.");
        }
    }
}
