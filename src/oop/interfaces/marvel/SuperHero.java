package oop.interfaces.marvel;

import java.util.ArrayList;
import java.util.Objects;

public abstract class SuperHero {
  private int strength;
  private int health;
  private String realName;
  private String nationality;
  private ArrayList<String> specialAbilities;

  public SuperHero(int strength, int health, String realName, String nationality) {
    this.strength = strength;
    this.health = health;
    this.realName = realName;
    this.nationality = nationality;
    this.specialAbilities = new ArrayList<>();
  }

  public SuperHero(int strength, int health, String realName, String nationality,
      ArrayList<String> specialAbilities) {
    this.strength = strength;
    this.health = health;
    this.realName = realName;
    this.nationality = nationality;
    this.specialAbilities = specialAbilities;
  }

  public void addSpecialAbility(String ability) {
    if (!specialAbilities.contains(ability)) {
      specialAbilities.add(ability);
    } else {
      System.out.println("Already exists.");
    }
  }

  public void removeSpecialAbility(String ability) {
    if (specialAbilities.contains(ability)) {
      specialAbilities.remove(ability);
    } else {
      System.out.println("Does not exist.");
    }
  }

  public abstract void fight();

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public String getRealName() {
    return realName;
  }

  public String getNationality() {
    return nationality;
  }

  public ArrayList<String> getSpecialAbilities() {
    return specialAbilities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuperHero superHero = (SuperHero) o;
    return strength == superHero.strength &&
        health == superHero.health &&
        Objects.equals(realName, superHero.realName) &&
        Objects.equals(nationality, superHero.nationality);
  }

  @Override
  public String toString() {
    return "SuperHero{" +
        "strength=" + strength +
        ", health=" + health +
        ", realName='" + realName + '\'' +
        ", nationality='" + nationality + '\'' +
        ", specialAbilities=" + specialAbilities +
        '}';
  }
}
