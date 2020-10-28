package lab3;

public class Knight extends Piece {
  private static final int VALUE = 2;

  public Knight(boolean isWhite) {
    super(VALUE, isWhite);
  }

  @Override
  public void move() {
    System.out.println("Like an L");
  }

  @Override
  public String toString() {
    return "Knight{value='" + getValue() + "', isWhite=" + isWhite() + "}";
  }
}
