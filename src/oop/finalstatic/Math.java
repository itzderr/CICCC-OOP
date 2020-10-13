package oop.finalstatic;

public class Math {
    // static var
    public static final double PI = 3.14;

    // non-static var
    public String name;

    // static method
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // non-static method
    public int min(int a, int b) {
        // unary 1, binary 2, ternary 3
        // * ternary operator
        // (condition) ? (true) : (false)
        return a > b ? b : a;
    }
}
