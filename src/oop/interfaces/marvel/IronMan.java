package oop.interfaces.marvel;

import java.util.ArrayList;

public class IronMan extends SuperHero implements Flyable {
  private int assets;
  private ArrayList<String> weapons;

  public IronMan(int strength, int health) {
    super(strength, health,"Tony Stark", "American");
    this.assets = 100;
    this.weapons = new ArrayList<>();
  }

  public void collectWeapon(String weapon) {
    this.weapons.add(weapon);
  }

  @Override
  public void fight() {
    System.out.println("IronMan is fighting...");
  }

  @Override
  public void fly(int distance) {
    if (assets > distance) {
      System.out.println("Flying...");
    }
  }
}
