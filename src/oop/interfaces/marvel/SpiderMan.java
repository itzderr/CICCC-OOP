package oop.interfaces.marvel;

public class SpiderMan extends SuperHero {
  private int numOfSuits;
  private int web;

  public SpiderMan(int strength, int health) {
    super(strength, health, "Peter Parker","American");
    this.numOfSuits = 1;
    this.web = 100;
  }

  @Override
  public void fight() {
    System.out.println("SpiderMan is fighting...");
  }
}
