package basics;
// python: snake_case
// java: camelCase
public class DataTypes {
    public static void main(String[] args) {
        // Primitive Types
        // - the value (itself) gets stored in memory

        // To create a variable in Java
        // Java is statically typed language!
        byte day = 127;        // 8 bits (-128 <=   <= 127)
        short year = 2020;     // 16 bits (-2^15 <=  <= 2^15 - 1)
        int age = 26;          // 32 bits (-2^31 <=  <= 2^31 - 1)
        long sin = 123456789L; // 64 bits (-2^63 <=  <= 2^63 - 1)

        char gender = 'M';  // 1 byte, 'F' char type -> single quotes, single char
        char ch = 65; // 'A'
        boolean flag = true;  // true or false
        float weight = 170.56f;  // 32 bits - floating point numbers
        double height = 180.23;  // 64 bits - (double-precision) floating point numbers

        // Operators
        // Arithmetic: +, -, *, /, %
        // Assignment: =
        // Comparison: >, <, >=, <=, ==, !=
        // Increment(Decrement): ++, --, +=, -=
        // Logical: && (and), || (or), ! (not)
        int x = 10;
        int y = ++x;  // x += 1
        int z = x++;
        System.out.println(x);  // 12
        System.out.println(y);  // 11
        System.out.println(z);  // 11
    }
}
