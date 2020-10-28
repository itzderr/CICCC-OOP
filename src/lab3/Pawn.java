package lab3;

import java.util.Objects;

public class Pawn extends Piece {
  private static final int VALUE = 1;

  private boolean promoted;
  private Piece newPiece;

  public Pawn(boolean isWhite) {
    super(VALUE, isWhite);
  }

  public Pawn(boolean isWhite, boolean promoted, Piece newPiece) {
    this(isWhite);
    this.promoted = promoted;
    this.newPiece = newPiece;
  }

  public void promote(Piece newPiece) {
    if (!promoted) {
      this.newPiece = newPiece;
      this.promoted = true;
    }
  }

  @Override
  public void move() {
    System.out.println("Forward 1");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Pawn pawn = (Pawn) o;
    return promoted == pawn.promoted &&
        Objects.equals(newPiece, pawn.newPiece);
  }

  @Override
  public String toString() {
    return "Pawn{value='" + getValue() + "', isWhite=" + isWhite() + "}";
  }
}
