package basics;


import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        // Array - "Fixed size", a sequence of elements of the same type
        // 1. array literal syntax
        int[] arr1 = {1, 2, 3, 4, 5};

        // the length (size) of array
        System.out.println(arr1.length);

        // access elements in array
        System.out.println(arr1[0]);
        System.out.println(arr1[arr1.length - 1]);

        // 1. traditional for-loop
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        // change the elem
        arr1[0] = 7;

        // 2. for each loop
        for (int elem : arr1) {
            System.out.println(elem);
        }

        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
