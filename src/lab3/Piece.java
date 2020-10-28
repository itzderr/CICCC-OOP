package lab3;

public abstract class Piece {
  private int value;
  private boolean isWhite;

  public Piece(int value, boolean isWhite) {
    this.value = value;
    this.isWhite = isWhite;
  }

  public abstract void move();

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public boolean isWhite() {
    return isWhite;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Piece piece = (Piece) o;
    return value == piece.value &&
        isWhite == piece.isWhite;
  }

  @Override
  public String toString() {
    return "Piece{" +
        "value=" + value +
        ", isWhite=" + isWhite +
        '}';
  }
}
