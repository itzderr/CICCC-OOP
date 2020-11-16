package chess;

/**
 * @author Derrick Park
 */
public enum Role {
    PAWN('P'), KNIGHT('N'), BISHOP('B'), ROOK('R'), QUEEN('Q'), KING('K');

    private final char symbol;

    Role(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Role fromSymbol(char symbol) {
        switch (symbol) {
            case 'P':
                return PAWN;
            case 'N':
                return KNIGHT;
            case 'B':
                return BISHOP;
            case 'R':
                return ROOK;
            case 'Q':
                return QUEEN;
            case 'K':
                return KING;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
