package midterm;

import java.util.ArrayList;

public class Driver {
  private static ArrayList<Vehicle> vehicles = new ArrayList<>();

  public static void main(String[] args) {
    vehicles.add(new Car("c1", 250, true));
    vehicles.add(new Car("c2", 220, true));
    vehicles.add(new Car("c3", -210, false));
    vehicles.add(new Boat("b1", 500));
    vehicles.add(new Boat("b2", 700));
    vehicles.add(new Boat("b3", 800));

    for (Vehicle vehicle : vehicles) {
      System.out.println(vehicle);
    }

    for (Vehicle vehicle : vehicles) {
      vehicle.accelerate();
    }
  }
}
