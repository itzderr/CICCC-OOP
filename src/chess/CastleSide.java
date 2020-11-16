package chess;

/**
 * @author Derrick Park
 */
public enum CastleSide {
    SHORT(5, 6, 7), LONG(3, 2, 0);

    private final int intermediateKingFile;
    private final int finalKingFile;
    private final int initialRookFile;

    CastleSide(int intermediateKingFile, int finalKingFile, int initialRookFile) {
        this.intermediateKingFile = intermediateKingFile;
        this.finalKingFile = finalKingFile;
        this.initialRookFile = initialRookFile;
    }

    public int getIntermediateKingFile() {
        return intermediateKingFile;
    }

    public int getFinalKingFile() {
        return finalKingFile;
    }

    public static CastleSide fromFinalKingFile(int file) {
        switch (file) {
            case 6:
                return SHORT;
            case 2:
                return LONG;
            default:
                return null;
        }
    }

    public int getInitialRookFile() {
        return initialRookFile;
    }

    public int getFinalRookFile() {
        return intermediateKingFile;
    }

    public int getDirection() {
        // return sgn(initialRookFile - 4)
        return Integer.compare(0, initialRookFile - 4);
    }

    @Override
    public String toString() {
        return this == SHORT ? "O-O" : "O-O-O";
    }
}
