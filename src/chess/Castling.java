package chess;

import java.util.Objects;

/**
 * Castling state.
 * @author Derrick Park
 */
public class Castling {
    private boolean whiteCanCastleShort = true;
    private boolean whiteCanCastleLong = true;
    private boolean blackCanCastleShort = true;
    private boolean blackCanCastleLong = true;

    public boolean canCastle(Color color, CastleSide side) {
        if (color == Color.WHITE) {
            return side == CastleSide.SHORT ? whiteCanCastleShort : whiteCanCastleLong;
        } else {
            return side == CastleSide.SHORT ? blackCanCastleShort : blackCanCastleLong;
        }
    }

    public void setCanCastle(Color color, boolean value) {
        if (color == Color.WHITE) {
            whiteCanCastleShort = whiteCanCastleLong = value;
        } else {
            blackCanCastleShort = blackCanCastleLong = value;
        }
    }

    public void setCanCastle(Color color, CastleSide side, boolean value) {
        if (color == Color.WHITE) {
            if (side == CastleSide.SHORT)
                whiteCanCastleShort = value;
            else
                whiteCanCastleLong = value;
        } else {
            if (side == CastleSide.SHORT)
                blackCanCastleShort = value;
            else
                blackCanCastleLong = value;
        }
    }

    /**
     * Possibly revoke castling rights as appropriate after a move.
     */
    public void onMove(Move move) {
        Square sq = move.getFrom();
        // Whose king are we dealing with?
        Color color = Color.fromBackRank(sq.getRank());
        if (color == null)
            return;
        if (sq.getFile() == 4) {
            // King moved
            setCanCastle(color, false);
        } else {
            // Rook moved
            CastleSide side = CastleSide.fromFinalKingFile(move.getTo().getFile());
            if (side == null)
                return;
            setCanCastle(color, side, false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Castling castling = (Castling) o;
        return whiteCanCastleShort == castling.whiteCanCastleShort &&
                whiteCanCastleLong == castling.whiteCanCastleLong &&
                blackCanCastleShort == castling.blackCanCastleShort &&
                blackCanCastleLong == castling.blackCanCastleLong;
    }

    @Override
    public int hashCode() {
        return Objects.hash(whiteCanCastleShort, whiteCanCastleLong, blackCanCastleShort, blackCanCastleLong);
    }

    @Override
    public String toString() {
        return "Castling{" +
                "whiteCanCastleShort=" + whiteCanCastleShort +
                ", whiteCanCastleLong=" + whiteCanCastleLong +
                ", blackCanCastleShort=" + blackCanCastleShort +
                ", blackCanCastleLong=" + blackCanCastleLong +
                '}';
    }
}
