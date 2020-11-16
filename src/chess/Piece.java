package chess;

import java.util.Objects;

/**
 * @author Derrick Park
 */
public class Piece {
    private final Role role;
    private final Color color;

    public Piece(Role role, Color color) {
        Objects.requireNonNull(role);
        Objects.requireNonNull(color);
        this.role = role;
        this.color = color;
    }

    public Role getRole() {
        return role;
    }

    public Color getColor() {
        return color;
    }

    public char getSymbol() {
        return color == Color.WHITE ? role.getSymbol() : Character.toLowerCase(role.getSymbol());
    }

    public char getUnicodeSymbol() {
        switch (role) {
            case KING:
                return color == Color.WHITE ? '♔' : '♚';
            case QUEEN:
                return color == Color.WHITE ? '♕' : '♛';
            case ROOK:
                return color == Color.WHITE ? '♖' : '♜';
            case BISHOP:
                return color == Color.WHITE ? '♗' : '♝';
            case KNIGHT:
                return color == Color.WHITE ? '♘' : '♞';
            case PAWN:
                return color == Color.WHITE ? '♙' : '♟';
            default:
                throw new AssertionError("unreachable code");
        }
    }

    /**
     * Check if the capture is valid, ignoring all other pieces, for the purpose of finding a check(mate).
     */
    @Deprecated
    public boolean canCapture(Square from, Square to) {
        int rankDiff = Math.abs(to.getRank() - from.getRank());
        int fileDiff = Math.abs(to.getFile() - from.getFile());
        if (rankDiff == 0 && fileDiff == 0)
            return false;
        if (role == Role.PAWN) {
            if (color == Color.WHITE) {
                return to.getRank() == from.getRank() + 1 && fileDiff == 1;
            } else {
                return to.getRank() == from.getRank() - 1 && fileDiff == 1;
            }
        }
        return canMove(from, to);
    }

    /**
     * Check if the move is valid, ignoring all other pieces. This ignores captures and castling.
     */
    @Deprecated
    public boolean canMove(Square from, Square to) {
        int rankDiff = Math.abs(to.getRank() - from.getRank());
        int fileDiff = Math.abs(to.getFile() - from.getFile());
        if (rankDiff == 0 && fileDiff == 0)
            return false;
        switch (role) {
            case PAWN:
                if (fileDiff != 0)
                    return false;
                if (color == Color.WHITE) {
                    return to.getRank() - from.getRank() == 1 || (to.getRank() - from.getRank() == 2 && from.getRank() == 1);
                } else {
                    return to.getRank() - from.getRank() == -1 || (to.getRank() - from.getRank() == -2 && from.getRank() == 6);
                }
            case KNIGHT:
                return (rankDiff == 2 && fileDiff == 1) || (fileDiff == 2 && rankDiff == 1);
            case BISHOP:
                return rankDiff == fileDiff;
            case ROOK:
                return rankDiff == 0 || fileDiff == 0;
            case QUEEN:
                return (rankDiff == fileDiff) || (rankDiff == 0 || fileDiff == 0);
            case KING:
                return rankDiff <= 1 && fileDiff <= 1;
            default:
                throw new AssertionError("unreachable code");
        }
    }

    @Override
    public String toString() {
        return Character.toString(getSymbol());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return role == piece.role &&
                color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, color);
    }
}
