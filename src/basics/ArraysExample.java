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

        // 2. create an array with "size"
        // - create a new array with size 10
        // - by default, initial values will be all zero
        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr2));

        // int[] arr3 = new int[] {1, 2};
        String[] countries = {"Canada", "Japan", "Brazil", "Spain", "Germany", "Korea"};
        for (String country : countries) {
            System.out.println(country);
        }
    }
}
