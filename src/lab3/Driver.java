package lab3;

import java.util.ArrayList;
import java.util.List;

public class Driver  {
    public static void main(String[] args) {

        // Arraylist contains all types of pieces
        ArrayList<Piece> pieces = new ArrayList<>();
        Pawn p1 = new Pawn(true, true, new Queen(true));
        Pawn p2 = new Pawn(true, false, null);
        Pawn p3 = new Pawn(false, false, null);
        Pawn p4 = new Pawn(false, true, new Queen(false));
        Pawn p5 = new Pawn(true, true, new Knight(true));
        Knight k1 = new Knight(true);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p4));
        System.out.println(p1.equals(p5));
        System.out.println(p2.equals(p3));
        System.out.println(p4.equals(p5));

        pieces.add(p1);
        pieces.add(p2);
        pieces.add(p3);
        pieces.add(p4);
        pieces.add(p5);
        pieces.add(k1);

        System.out.println();
        System.out.println(p1);
        System.out.println(pieces);
        System.out.println(k1);
        k1.move();
    }
}
