package chess;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Derrick Park
 */
public class Launcher {
    private static void readMove(Scanner sc, Game game) {
        while (true) {
            System.out.println();
            if (game.getColorToMove() == Color.WHITE) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }
            System.out.print("Enter UCI (type 'help' for help): ");
            String s = sc.nextLine();
            Square square = Square.parse(s);
            Move move = Move.parseUCI(s);
            if (s.isEmpty() || s.equals("help")) {
                printHelp();
            } else if ("board".equals(s)) {
                System.out.println();
                System.out.println(game.toString(true, true));
            } else if ("resign".equals(s)) {
                game.resign();
                break;
            } else if ("moves".equals(s)) {
                printMoves(game);
            } else if (square != null) {
                printMovesForSquare(game, square);
            } else if (move != null) {
                if (performMove(game, move)) return;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
    }

    private static boolean performMove(Game game, Move move) {
        if (game.move(move)) {
            System.out.println("OK");
            return true;
        } else {
            System.out.println("Illegal move, please try again");
            return false;
        }
    }

    private static void printMovesForSquare(Game game, Square square) {
        SquareSet set = game.getAvailableMovesForPieceAt(square);
        if (set.isEmpty()) {
            System.out.println("No possible moves for " + square);
        } else {
            System.out.println("Possible moves for " + square + ":");
            System.out.println(set);
        }
    }

    private static void printMoves(Game game) {
        System.out.println("Possible moves:");
        HashMap<Square, SquareSet> moves = game.getAvailableMoves();
        moves.keySet().stream().sorted()
                .forEach(sq -> System.out.println(sq + " - " + moves.get(sq)));
    }

    private static void printHelp() {
        System.out.println("* type 'help' for help");
        System.out.println("* type 'board' to see the board again");
        System.out.println("* type 'resign' to resign");
        System.out.println("* type 'moves' to list all possible moves");
        System.out.println("* type a square (e.g. b1, e2) to list possible moves for that square");
        System.out.println("* type UCI (e.g. b1c3, e7e8q) to make a move");
    }

    private static String getTerminationDescription(Termination termination) {
        switch (termination) {
            case WHITE_WON_CHECKMATE:
                return "White won by checkmate";
            case BLACK_WON_CHECKMATE:
                return "Black won by checkmate";
            case WHITE_WON_RESIGNATION:
                return "White won by resignation";
            case BLACK_WON_RESIGNATION:
                return "Black won by resignation";
            case DRAW_STALEMATE:
                return "Draw by stalemate";
            case DRAW_FIFTY_MOVE:
                return "Draw by fifty-move rule";
            default:
                throw new AssertionError("Invalid termination");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println(game.toString(true, true));
            Termination term = game.getTermination();
            if (term != null) {
                String desc = getTerminationDescription(term);
                System.out.println();
                System.out.println("Game over - " + term.getScore() + " - " + desc);
                break;
            }
            readMove(sc, game);
        }
    }
}
