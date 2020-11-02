package midterm;

public class Boat extends Vehicle {

  public Boat(String productId, Integer weight) {
    super(productId, weight);
  }

  @Override
  public void accelerate() {
    System.out.println("jet water");
  }

  @Override
  public void steerLeft() {
    System.out.println("turn tiller left");
  }

  @Override
  public void steerRight() {
    System.out.println("turn tiller right");
  }

  @Override
  public String toString() {
    return "Boat{productId='" + getProductId() + '\'' +
        ", weight=" + getWeight() + '}';
  }
}
