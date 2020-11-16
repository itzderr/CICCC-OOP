package chess;

import java.util.Objects;

/**
 * @author Derrick Park
 */
public class Move {
    private final Square from;
    private final Square to;
    private final Role promoteTo;

    public Move(Square from, Square to, Role promoteTo) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        this.from = from;
        this.to = to;
        this.promoteTo = promoteTo;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    public Role getPromoteTo() {
        return promoteTo;
    }

    public static Move parseUCI(String uci) {
        if (uci.length() != 4 && uci.length() != 5)
            return null;
        Square from = Square.parse(uci.substring(0, 2));
        Square to = Square.parse(uci.substring(2, 4));
        if (from == null || to == null)
            return null;
        Role promote = null;
        if (uci.length() == 5) {
            char ch = uci.charAt(4);
            if (!Character.isLowerCase(ch))
                return null;
            promote = Role.fromSymbol(Character.toUpperCase(ch));
            if (promote == null)
                return null;
        }
        return new Move(from, to, promote);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return from.equals(move.from) &&
                to.equals(move.to) &&
                promoteTo == move.promoteTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, promoteTo);
    }

    @Override
    public String toString() {
        String s = from.toString() + to.toString();
        if (promoteTo != null)
            s += Character.toLowerCase(promoteTo.getSymbol());
        return s;
    }
}
