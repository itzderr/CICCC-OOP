package lab3;

public class King extends Piece {
  private static final int VALUE = 1000;

  public King(boolean isWhite) {
    super(VALUE, isWhite);
  }

  @Override
  public void move() {
    System.out.println("One square");
  }

  @Override
  public String toString() {
    return "King{value='" + getValue() + "', isWhite=" + isWhite() + "}";
  }
}
