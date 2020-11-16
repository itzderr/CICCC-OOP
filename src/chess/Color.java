package chess;

/**
 * @author Derrick Park
 */
public enum Color {
    WHITE(0, 1), BLACK(7, -1);

    private final int backRank;
    private final int forward;

    Color(int backRank, int forward) {
        this.backRank = backRank;
        this.forward = forward;
    }

    public int getBackRank() {
        return backRank;
    }

    public static Color fromBackRank(int rank) {
        switch (rank) {
            case 0:
                return WHITE;
            case 7:
                return BLACK;
            default:
                return null;
        }
    }

    public int getForward() {
        return forward;
    }

    /**
     * Get the actual rank index for the nth (zero-indexed) rank from this color's perspective.
     * <p>
     * For example, {@code Color.BLACK.getNthRank(1)} returns {@code 6}.
     */
    public int getNthRank(int n) {
        return backRank + n * forward;
    }

    public Color other() {
        if (this == WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }
}
