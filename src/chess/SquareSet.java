package chess;

import java.util.Objects;

/**
 * A set of squares on the chessboard, which is internally represented by 64 booleans.
 * @author Derrick Park
 */
public class SquareSet {
    // 64 booleans represented as a 64-bit long
    private long value;

    public SquareSet() {
        this(0);
    }

    private SquareSet(long value) {
        this.value = value;
    }

    public boolean contains(Square square) {
        int bit = square.getRank() * 8 + square.getFile();
        return (value & (1L << bit)) != 0;
    }

    public void add(Square square) {
        int bit = square.getRank() * 8 + square.getFile();
        this.value |= (1L << bit);
    }

    public void remove(Square square) {
        int bit = square.getRank() * 8 + square.getFile();
        this.value &= ~(1L << bit);
    }

    /**
     * Union between the two sets.
     */
    public SquareSet union(SquareSet other) {
        return new SquareSet(this.value | other.value);
    }

    public boolean isEmpty() {
        return value == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareSet set = (SquareSet) o;
        return value == set.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        boolean first = true;
        for (int file = 0; file < 8; file++) {
            for (int rank = 0; rank < 8; rank++) {
                int bit = rank * 8 + file;
                if ((value & (1L << bit)) != 0) {
                    if (first) {
                        first = false;
                    } else {
                        s.append(", ");
                    }
                    s.append(new Square(file, rank));
                }
            }
        }
        s.append('}');
        return s.toString();
    }
}
