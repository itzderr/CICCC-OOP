package lab1;

public class Driver {
    public static void main(String[] args) {
        Model susan = new Model("Susan", "Smith",
                70, 120,true,false);

        Model tiger = new Model("Tiger",
                "Woods", 72, 190, true, false);

        susan.displayModelDetails();
        System.out.println();
        tiger.displayModelDetails();
    }
}
