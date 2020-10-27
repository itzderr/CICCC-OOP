package oop.interfaces.caravan;

public abstract class Vehicle implements Movable {
  private int fuel;
  private String brand;

  public Vehicle(String brand) {
    this.fuel = 0;
    this.brand = brand;
  }

  public int getFuel() {
    return fuel;
  }

  public void setFuel(int fuel) {
    this.fuel = fuel;
  }
}
