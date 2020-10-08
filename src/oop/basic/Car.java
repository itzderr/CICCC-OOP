package oop.basic;
// Car - define a new "class" (new type)
// - data fields (variables) (states) - color, brand, year, hp, seats ...
// - methods (behaviors) - drive, stop, ...
//
// 1. blueprint (class)
// 2. you can create many car objects (instances)
public class Car {
    /////////////////////////////////
    // Instance variables (states) //
    // - data fields               //
    /////////////////////////////////
    String color;
    String brand;
    int year;
    int horsePower;
    int seats;

    ///////////////////////////////////////////////////
    // Constructor: to create a new instance(object) //
    // - 'initialize' instance variables             //
    ///////////////////////////////////////////////////
    Car() {
        this.color = "White";
        this.brand = "";
        this.year = 2020;
        this.horsePower = 0;
        this.seats = 5;
    }

    Car(String color, String brand, int year, int horsePower, int seats) {
        // 'this' refers to the instance that's being used
        // 'this': self reference
        this.color = color;
        this.brand = brand;
        this.year = year;
        this.horsePower = horsePower;
        this.seats = seats;
    }

    /////////////////////////
    // Methods (behaviors) //
    /////////////////////////

    // 'method overloading'
    // - create methods with the same name with different set of parameters
    void drive(int speed) {
        System.out.println("Driving " + this.brand + " at " + speed + " km/h");
    }

    void drive() {
        System.out.println("Driving..." + this.brand);
    }

    void stop() {
        System.out.println("Stopping...");
    }
}
