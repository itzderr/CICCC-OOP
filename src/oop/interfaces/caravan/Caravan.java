package oop.interfaces.caravan;

public class Caravan implements Habitable, Movable {
    // data field
    private int maxCapacity;
    /* a distance from 0 (home) to current location */
    private int location;

    // constructor
    public Caravan(int maxCapacity, int location){
        this.maxCapacity = maxCapacity;
        this.location = location;
    }

    @Override
    public boolean canFit(int inhabitants) {
        return inhabitants <= maxCapacity;
    }

    @Override
    public void move(int distance) {
        location += distance;
    }

    @Override
    public boolean canMove() {
        return true;
    }
}
