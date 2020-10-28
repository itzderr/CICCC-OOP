package lab3;

public class Bishop extends Piece {
  private static final int VALUE = 3;

  public Bishop(boolean isWhite) {
    super(VALUE, isWhite);
  }

  @Override
  public void move() {
    System.out.println("Diagonally");
  }

  @Override
  public String toString() {
    return "Bishop{value='" + getValue() + "', isWhite=" + isWhite() + "}";
  }
}
