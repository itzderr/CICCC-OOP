package basics;

// Memory
// - Heap
// - Stack
// - Data
// - Code
public class StringsExample {
    public static void main(String[] args) {
        // 1. string literal
        String name = "Derrick";  // data segment (read only)
        String name1 = new String("Derrick");
        String name2 = "Derrick";

        // comparing memory address
        System.out.println(name == name2);   // true
        System.out.println(name1 == name2);  // false

        // comparing strings (contents) the right way
        System.out.println(name1.equals(name2)); // true

        // length (the number of characters)
        System.out.println(name.length());

        String cafe = "Starbucks"; // second cup, blenz, tim horton's
        //             012345678
        // 0 <=   < 4
        System.out.println(cafe.substring(0, 4));  // Star
        System.out.println(cafe.indexOf("bucks")); // 4

        // Exercise
        // print every single char in a String
        String brand = "Panasonic";
        for (int i = 0; i < brand.length(); i++) {
            System.out.println(brand.substring(i, i + 1));  // string "P"
            System.out.println(brand.charAt(i));  // char 'P'
        }

        // "Sony" -> {'S', 'o', 'n', 'y'}
        for (char ch : brand.toCharArray()) {
            System.out.println(ch);
        }
    }
}
