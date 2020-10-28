package oop.interfaces.marvel;

public class SpiderMan extends SuperHero{
    // data field (specific to this subclass only)
    private int numOfSuits;
    private int web;

    public SpiderMan(int strength, int health){
        // using the constructor1 from superclass
        super(strength, health, "Peter Parker", "American");
        this.numOfSuits = 1;
        this.web = 100;
    }

    @Override
    public void fight() {
        System.out.println("SpiderMan is fighting");
    }
}
