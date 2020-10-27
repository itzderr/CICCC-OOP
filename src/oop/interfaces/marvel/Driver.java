package oop.interfaces.marvel;

import java.util.ArrayList;

public class Driver {

  public static void main(String[] args) {
    ArrayList<Flyable> characters = new ArrayList<>();
    Flyable ironMan = new IronMan(100, 100);
    Flyable thor = new Thor(100, 100);
    characters.add(ironMan);
    characters.add(thor);
  }
}
