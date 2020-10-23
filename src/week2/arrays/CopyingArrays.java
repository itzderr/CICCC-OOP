package week2.arrays;

import java.util.Arrays;

public class CopyingArrays {
    public static void main(String[] args) {
        int [] arr1 = new int[10];                                              // declare first arr
        int max = 100;
        int min = 1;
        for (int i = 0; i < arr1.length ; i++) {
            double random_double = Math.random() * (max - min + 1) + min;
            int random_int = (int) Math.round(random_double);
            arr1[i] = random_int;
        }

        int [] arr2 = Arrays.copyOfRange(arr1,0,arr1.length );              // copy the first arr to second arr
        arr1[arr1.length - 1] = -7;                                              // change the value of the last index
        System.out.print("Array 1:  ");
        for (int i = 0; i < arr1.length ; i++){
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\nArray 2:  ");
        for (int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }
    }
}
