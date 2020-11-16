package chess;

import java.util.Objects;

/**
 * A square on the chess board with a zero-indexed file and rank.
 * @author Derrick Park
 */
public class Square implements Comparable<Square> {
    private int file;
    private int rank;

    public Square(int file, int rank) {
        if (file < 0 || file > 7 || rank < 0 || rank > 7) {
            throw new IllegalArgumentException("Invalid file/rank: file=" + file + ", rank=" + rank);
        }
        this.file = file;
        this.rank = rank;
    }

    /**
     * Zero-indexed file.
     */
    public int getFile() {
        return file;
    }

    /**
     * Zero-indexed rank.
     */
    public int getRank() {
        return rank;
    }

    public Square withFile(int file) {
        return new Square(file, rank);
    }

    public Square withRank(int rank) {
        return new Square(file, rank);
    }

    public Square add(int file, int rank) {
        return new Square(this.file + file, this.rank + rank);
    }

    public Square addFile(int file) {
        return add(file, 0);
    }

    public Square addRank(int rank) {
        return add(0, rank);
    }

    public static Square parse(String s) {
        if (s.length() != 2)
            return null;
        int file = "abcdefgh".indexOf(s.charAt(0));
        if (file == -1)
            return null;
        int rank = s.charAt(1) - '1';
        if (rank < 0 || rank >= 8)
            return null;
        return new Square(file, rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return file == square.file &&
                rank == square.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return Character.toString("abcdefgh".charAt(file)) + (rank + 1);
    }

    @Override
    public int compareTo(Square o) {
        int c = Integer.compare(this.file, o.file);
        if (c == 0) {
            return Integer.compare(this.rank, o.rank);
        } else {
            return c;
        }
    }
}
