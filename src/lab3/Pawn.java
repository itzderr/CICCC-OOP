package lab3;

import java.lang.reflect.Array;
import java.util.Objects;

public class Pawn extends Piece{

    // new instance variable
    private boolean promoted;
    private Piece newPiece;

    public Pawn(boolean isWhite, boolean promoted, Piece newPiece) {
        super(1, isWhite);                                               // Pawn value is always 1
        this.promoted = promoted;
        this.newPiece = newPiece;
    }

    // getter
    public boolean getPromoted(){
        return promoted;
    }
    public Piece getNewPiece(){
        return newPiece;
    }

    // setter
    public void setNewPiece(Piece newPiece)  {
        this.newPiece = newPiece;
    }

    @Override
    public String toString() {
        return "Pawn{value='" + getValue() + '\'' + '}';
    }

    public void move(){
        System.out.println("Forward 1");
    }

    // when not promoted -> create new piece
    public void promote(Piece newPiece){
        if (!promoted){
            this.newPiece = newPiece;
        }
    }

    // override equals method -> Pawns are Not equal if promoted
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pawn pawn = (Pawn) o;
        return promoted == pawn.promoted &&
                Objects.equals(newPiece, pawn.newPiece);
    }
}
