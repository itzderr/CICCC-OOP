package week1.variables;

public class StillUsingVariables {
    public static void nameAgeYears(String name, int years) {
        String str = String.format("My name is %s and I'll graduate in %d", name, years);
        System.out.println(str);
    }

    public static void main(String[] args) {
        nameAgeYears("Juan", 2010);
    }
}
