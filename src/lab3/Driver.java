package lab3;

import java.util.ArrayList;

// intellij shortcuts
// (mac) cmd + n -> auto generate
// (windows, linux) alt + insert

// (mac) shift + shift  -> open file
// (windows, linux) shift + shift or ctrl + n

// cmd(ctrl) + f -> find
// cmd(ctrl) + shift + r -> replace
public class Driver {
  public static void main(String[] args) {
    King k = new King(true);
    Queen q = new Queen(true);
    Rook r = new Rook(true);
    Bishop b = new Bishop(true);
    Knight kn = new Knight(true);
    Pawn p = new Pawn(true);

    ArrayList<Piece> pieces = new ArrayList<>();
    pieces.add(k);
    pieces.add(q);
    pieces.add(r);
    pieces.add(b);
    pieces.add(kn);
    pieces.add(p);

    for (Piece piece : pieces) {
      piece.move();
    }

    Pawn p1 = new Pawn(true, true, new Queen(true));
    Pawn p2 = new Pawn(true, false, null);
    Pawn p3 = new Pawn(false, false, null);
    Pawn p4 = new Pawn(false, true, new Queen(false));
    Pawn p5 = new Pawn(true, true, new Knight(true));

    System.out.println(p1.equals(p2));
    System.out.println(p1.equals(p4));
    System.out.println(p1.equals(p5));
    System.out.println(p2.equals(p3));
    System.out.println(p4.equals(p5));
  }
}
