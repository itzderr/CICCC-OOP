package oop.interfaces.caravan;

public class Car extends Vehicle {
  private int numOfSeats;

  public Car(String brand, int numOfSeats) {
    super(brand);
    this.numOfSeats = numOfSeats;
  }

  @Override
  public void move(int distance) {
    if (distance < 0) {
      System.out.println("Wrong distance");
    } else {
      if (getFuel() >= distance) {
        System.out.println("moving to the destination.");
      } else {
        System.out.println("cannot reach to the destination.");
        System.out.println("not enough fuel.");
      }
      setFuel(getFuel() - distance);
    }
  }

  @Override
  public boolean canMove() {
    return getFuel() > 0;
  }
}
