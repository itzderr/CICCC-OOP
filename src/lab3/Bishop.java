package lab3;

public class Bishop extends Piece{

    public Bishop(boolean isWhite) {
        super(3, isWhite);
    }

    @Override
    public String toString() {
        return "Bishop{value='" + getValue() + '\'' + '}';
    }

    public void move(){
        System.out.println("Diagonally");
    }
}
