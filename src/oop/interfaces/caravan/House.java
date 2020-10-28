package oop.interfaces.caravan;

public class House implements Habitable{
    // data field
    private int numOfBedrooms;
    private int builtYear;

    // constructor
    public House(int numOfBedrooms, int builtYear){
        this.numOfBedrooms = numOfBedrooms;
        this.builtYear = builtYear;
    }

    @Override
    public boolean canFit(int inhabitants) {
        return numOfBedrooms * 2 >= inhabitants;
    }


}
