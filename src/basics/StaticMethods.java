package basics;

import java.util.Arrays;

public class StaticMethods {
    public static void main(String[] args) {
        System.out.println(addTwo(10, 20));
        int a = 10;
        int b = 20;
        System.out.printf("a = %d, b = %d\n", a, b);
        swap(a, b);
        System.out.printf("a = %d, b = %d\n", a, b);

        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr)); // [1, 2, 3]
        changeFirstElement(arr);
        System.out.println(Arrays.toString(arr)); // [7, 2, 3]

        // copying an array
        int[] arr1 = arr.clone();
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr2));

        System.out.println(arr == arr1);  // false (reference)
        System.out.println(arr == arr2);  // false
        System.out.println(Arrays.equals(arr, arr1));  // true (contents)
    }

    // pass by reference
    public static void changeFirstElement(int[] array) {
        array[0] = 7;
    }

    // pass by value
    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    // In Python
    // def add_two(a: int, b: int) -> int:
    //     return a + b
    public static int addTwo(int a, int b) {
        return a + b;
    }
}


