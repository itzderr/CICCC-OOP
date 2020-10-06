package basics;

public class Loops {
    public static void main(String[] args) {
        // * variable
        // 1. declare a var: give a type and name
        int age;
        // 2. initialize a var: setting an initial value
        age = 25;

        // 1. for-loop
        // for (initialize var; condition; inc or dec) {
        //     code to repeat
        // }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }

        // Infinite loop
        for (;;) {
            System.out.println("Hi");
            break;
        }

        // 2. while-loop
        while (true) {
            System.out.println("Bye");
            break;
        }

        // Exercise
        // Using for-loop
        // 1. print integer from 1 to 20 but 10 numbers each line
        // (output)
        // 1 2 3 4 5 6 7 8 9 10
        // 11 12 13 14 15 16 17 18 19 20
        for (int i = 1; i <= 20; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
            } else {
                System.out.print(i + " ");
            }
        }

        // Using while-loop
        // 2. print even numbers from 1 to 100
        // (output)
        // 2 4 6 8 ... 100
        int k = 2;
        while (k <= 100) {
            System.out.println(k);
            k += 2;
        }
    }
}
