package lab3;

public class Rook extends Piece {
  private static final int VALUE = 5;

  public Rook(boolean isWhite) {
    super(VALUE, isWhite);
  }

  @Override
  public void move() {
    System.out.println("Horizontally or vertically");
  }

  @Override
  public String toString() {
    return "Rook{value='" + getValue() + "', isWhite=" + isWhite() + "}";
  }
}
