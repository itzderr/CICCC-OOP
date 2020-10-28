package oop.interfaces.caravan;

public abstract class Vehicle implements Movable {
    // data field
    public int fuel;
    private String brand;

    // constructor
    public Vehicle(String brand){
        this.fuel = 0;
        this.brand = brand;
    }

    //getter
    public int getFuel(){
        return fuel;
    }

    // setter
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
