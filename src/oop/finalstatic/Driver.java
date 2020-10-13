package oop.finalstatic;

public class Driver {
    public static void main(String[] args) {
        // static - it belongs to a class itself (blueprint)
        // final - constant (cannot modify)
        final int x = 10;
        System.out.println(Math.PI); // static var

        Math m = new Math();
        m.name = "Math Library"; // non-static (data fields, instance var)
        Math m1 = new Math();
        m1.name = "Math Library1";

        // static method
        int max = Math.max(10, 20);
        System.out.println(max);

        // non-static method (instance method)
        int min = m.min(10, 20);
        System.out.println(min);


        try {
            Time t1 = new Time(17, 29, 9);
            Time t2 = new Time(15, 2, 19);
            Time t3 = new Time(20, 21, 29);
            Time t4 = new Time(5, 0, 39);
            Time t5 = new Time(21, 39, 49);
            System.out.println("Instance Count: " + Time.getInstanceCount());

            Time[] times = {t1, t2, t3, t4, t5};
            for (Time time : times) {
                System.out.println(time.toUniversalForm());
                System.out.println(time.toStandardForm());
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }


    }
}
