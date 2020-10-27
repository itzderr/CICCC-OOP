package oop.interfaces.caravan;

public class Driver {
  public static void main(String[] args) {
    Habitable c0 = new Caravan(10, 0);
    Movable c1 = new Caravan(10, 0);
    Movable c2 = new Car("BMW", 2);
    Habitable c3 = new House(5, 2020);
  }
}
