package chess;

/**
 * @author Derrick Park
 */
public enum Termination {
    WHITE_WON_CHECKMATE("1-0"),
    BLACK_WON_CHECKMATE("0-1"),
    WHITE_WON_RESIGNATION("1-0"),
    BLACK_WON_RESIGNATION("0-1"),
    DRAW_STALEMATE("½-½"),
    DRAW_FIFTY_MOVE("½-½");

    private final String score;

    Termination(String score) {
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public static Termination winByCheckmate(Color color) {
        return color == Color.WHITE ? WHITE_WON_CHECKMATE : BLACK_WON_CHECKMATE;
    }

    public static Termination winByResignation(Color color) {
        return color == Color.WHITE ? WHITE_WON_RESIGNATION : BLACK_WON_RESIGNATION;
    }
}
