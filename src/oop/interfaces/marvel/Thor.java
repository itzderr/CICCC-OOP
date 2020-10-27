package oop.interfaces.marvel;
// "composition over inheritance"
// "interface over abstract classes"
// "less coupling"
public class Thor extends SuperHero implements Flyable {
  private String status;

  public Thor(int strength, int health){
    super(strength, health, "Christopher Hemsworth", "Australian");
    this.status = "Prince";
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public void fight() {
    System.out.println("Thor is fighting...");
  }

  @Override
  public void fly(int distance) {
    if (distance > 0 && getHealth() > 0) {
      System.out.println("Flying...");
    }
  }
}
