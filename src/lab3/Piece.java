package lab3;

import java.util.Objects;

public abstract class Piece {
    // instance variable field
    private int value;                    // indicate importance of each
    private boolean isWhite;

    // constructor
    public Piece(int value, boolean isWhite){
        this.value = value;
        this.isWhite = isWhite;
    }

    //accessor(getter)
    public int getValue() {
        return value;
    }
    public boolean getIsWhite(){
        return isWhite;
    }

    // mutator(setter)
    public void setValue(int value){
        this.value = value;
    }
    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

// override toString() method -> return string representation of each Piece
    @Override
    public String toString() {
        return "Piece{" +
                "value=" + value +
                ", isWhite=" + isWhite +
                '}';
    }

    // if two Piece objects have the same value and color, return true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return value == piece.value &&
                isWhite == piece.isWhite;
    }

    // abstract method must be overridden by concrete subclasses
    public abstract void move();        // no implementation here

}
