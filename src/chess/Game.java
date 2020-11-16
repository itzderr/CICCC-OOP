package chess;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Derrick Park
 */
public class Game {
    private Piece[][] board;
    private Color colorToMove = Color.WHITE;
    private Square enPassantSquare = null;
    private Castling castling = new Castling();
    private Termination termination = null;
    private int semiMovesSinceLastPawnMoveOrCapture = 0;

    public Game() {
        board = new Piece[8][8];
        board[0][0] = board[0][7] = new Piece(Role.ROOK, Color.WHITE);
        board[7][0] = board[7][7] = new Piece(Role.ROOK, Color.BLACK);
        board[0][1] = board[0][6] = new Piece(Role.KNIGHT, Color.WHITE);
        board[7][1] = board[7][6] = new Piece(Role.KNIGHT, Color.BLACK);
        board[0][2] = board[0][5] = new Piece(Role.BISHOP, Color.WHITE);
        board[7][2] = board[7][5] = new Piece(Role.BISHOP, Color.BLACK);
        board[0][3] = new Piece(Role.QUEEN, Color.WHITE);
        board[7][3] = new Piece(Role.QUEEN, Color.BLACK);
        board[0][4] = new Piece(Role.KING, Color.WHITE);
        board[7][4] = new Piece(Role.KING, Color.BLACK);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Piece(Role.PAWN, Color.WHITE);
            board[6][i] = new Piece(Role.PAWN, Color.BLACK);
        }
    }

    public Color getColorToMove() {
        return colorToMove;
    }

    public Piece get(Square sq) {
        return board[sq.getRank()][sq.getFile()];
    }

    private void set(Square sq, Piece piece) {
        board[sq.getRank()][sq.getFile()] = piece;
    }

    /**
     * Make a move. If it is legal, this method performs the move, which mutates this board's state, and returns true.
     * If the move is illegal, then no action is performed and this method returns false.
     */
    public boolean move(Move move) {
        SquareSet availableMoves = getAvailableMovesForPieceAt(move.getFrom());
        if (!availableMoves.contains(move.getTo()))
            return false;
        Piece piece = get(move.getFrom());
        // Check that the promotion information is provided
        if (piece.getRole() == Role.PAWN && move.getTo().getRank() == colorToMove.other().getBackRank()) {
            if (move.getPromoteTo() == null)
                return false;
        } else {
            if (move.getPromoteTo() != null)
                return false;
        }

        int deltaFile = move.getTo().getFile() - move.getFrom().getFile();
        boolean isCapture;

        if (piece.getRole() == Role.KING && Math.abs(deltaFile) == 2) {
            // Castling
            assert move.getTo().getRank() == colorToMove.getBackRank();
            CastleSide side = CastleSide.fromFinalKingFile(move.getTo().getFile());
            assert side != null;
            Square rookSquare = move.getTo().withFile(side.getInitialRookFile());
            Piece rook = get(rookSquare);
            set(rookSquare, null);
            set(move.getTo().withFile(side.getFinalRookFile()), rook);
            set(move.getFrom(), null);
            set(move.getTo().withFile(side.getFinalKingFile()), piece);
            isCapture = false;
        } else if (piece.getRole() == Role.PAWN && deltaFile != 0 && move.getTo().equals(enPassantSquare)) {
            // En passant
            Square capturedSquare = move.getFrom().withFile(move.getTo().getFile());
            assert get(capturedSquare).getRole() == Role.PAWN;
            assert get(capturedSquare).getColor() != colorToMove;
            set(move.getTo(), piece);
            set(move.getFrom(), null);
            set(capturedSquare, null);
            isCapture = true;
        } else if (move.getPromoteTo() != null) {
            // Promoting
            isCapture = get(move.getTo()) != null;
            set(move.getTo(), new Piece(move.getPromoteTo(), colorToMove));
            set(move.getFrom(), null);
        } else {
            // Normal move
            isCapture = get(move.getTo()) != null;
            set(move.getTo(), piece);
            set(move.getFrom(), null);
        }

        // Update game state
        enPassantSquare = null;
        if (piece.getRole() == Role.PAWN) {
            int deltaRank = move.getTo().getRank() - move.getFrom().getRank();
            if (Math.abs(deltaRank) == 2) {
                enPassantSquare = move.getFrom().addRank(sgn(deltaRank));
            }
        }
        if (isCapture || piece.getRole() == Role.PAWN) {
            semiMovesSinceLastPawnMoveOrCapture = 0;
        } else {
            semiMovesSinceLastPawnMoveOrCapture++;
        }
        // Revoke right to castle as appropriate
        castling.onMove(move);
        colorToMove = colorToMove.other();
        calculateTermination();
        return true;
    }

    private static final int[][] KNIGHT_MOVES = {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
    private static final int[][] BISHOP_MOVES = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    private static final int[][] ROOK_MOVES = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /**
     * Get all of the available, legal moves (including captures, castling, and en passant) for the piece at the given
     * square. If there is no piece at the given square, this method returns an empty set.
     */
    public SquareSet getAvailableMovesForPieceAt(Square square) {
        Objects.requireNonNull(square);
        if (termination != null)
            return new SquareSet();
        Piece piece = get(square);
        if (piece == null)
            return new SquareSet();
        if (piece.getColor() != colorToMove)
            return new SquareSet();
        SquareSet controlled = getSuperficialControlledSquaresFor(colorToMove.other());
        SquareSet set = new SquareSet();

        if (piece.getRole() == Role.PAWN) {
            // Special case: Pawns may move forward and can only move diagonally if capturing.
            int forward = colorToMove.getForward();
            updateSetForMovesInDirection(set, square, forward, 0,
                    (square.getRank() == colorToMove.getNthRank(1)) ? 2 : 1, false);
            for (int df : new int[]{-1, 1}) {
                try {
                    Square captureSquare = square.add(df, forward);
                    if (captureSquare.equals(enPassantSquare) ||
                            (get(captureSquare) != null && get(captureSquare).getColor() != colorToMove)) {
                        // We can capture here
                        set.add(captureSquare);
                    }
                } catch (IllegalArgumentException ignored) {
                    // Ignore error when the square is out of bounds
                }
            }
        } else {
            set = getControlledSquaresForPieceAt(square);
            if (piece.getRole() == Role.KING && !controlled.contains(square)) {
                // Special case: Kings may castle.
                sides:
                for (CastleSide side : CastleSide.values()) {
                    if (castling.canCastle(colorToMove, side)) {
                        // Check that there are no pieces between the king and the rook
                        int direction = side.getDirection();
                        for (int file = 4 + direction; file != side.getInitialRookFile(); file += direction) {
                            if (board[colorToMove.getBackRank()][file] != null)
                                continue sides; // fail
                        }
                        // Make sure the king does not pass through check.
                        if (controlled.contains(square.withFile(side.getIntermediateKingFile())))
                            continue; // fail
                        set.add(new Square(side.getFinalKingFile(), colorToMove.getBackRank()));
                    }
                }
            }
        }

        // Check for pinned pieces and other moves that cause your own king to get into check
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square dest = new Square(j, i);
                if (!set.contains(dest))
                    continue;
                Piece captured = get(dest);
                // Cannot capture the same color
                if (captured != null && captured.getColor() == piece.getColor()) {
                    set.remove(dest);
                    continue;
                }
                set(dest, piece);
                set(square, null);
                if (isInCheck(colorToMove))
                    set.remove(dest);
                set(square, piece);
                set(dest, captured);
            }
        }

        return set;
    }

    /**
     * Get the controlled squares (squares where the piece is able to capture, even if there is no piece to capture, or
     * the piece to capture is of the same color as the capturing piece) for a piece at the given square, ignoring
     * pinned pieces. This is useful for finding checks. If there is no piece at the given square, this method returns
     * an empty set.
     */
    private SquareSet getControlledSquaresForPieceAt(Square square) {
        Objects.requireNonNull(square);
        Piece piece = get(square);
        SquareSet set = new SquareSet();
        if (piece == null)
            return set; // No moves
        switch (piece.getRole()) {
            case PAWN:
                int direction = piece.getColor() == Color.WHITE ? 1 : -1;
                // for df = -1, 1
                for (int df = -1; df <= 1; df += 2) {
                    try {
                        Square captureSquare = square.add(df, direction);
                        set.add(captureSquare);
                    } catch (IllegalArgumentException ignored) {
                        // Ignore error if the square is out of bounds
                    }
                }
                break;
            case KNIGHT:
                for (int[] move : KNIGHT_MOVES)
                    updateSetForMovesInDirection(set, square, move[0], move[1], 1, true);
                break;
            default: { // Handles bishop, rook, queen, and king
                int limit = piece.getRole() == Role.KING ? 1 : 8;
                if (piece.getRole() != Role.ROOK) {
                    for (int[] move : BISHOP_MOVES)
                        updateSetForMovesInDirection(set, square, move[0], move[1], limit, true);
                }
                if (piece.getRole() != Role.BISHOP) {
                    for (int[] move : ROOK_MOVES)
                        updateSetForMovesInDirection(set, square, move[0], move[1], limit, true);
                }
            }
        }
        return set;
    }

    /**
     * Get all the controlled squares for all pieces of a certain color. The enemy cannot move into a square if and only
     * if the square is in the set returned by this method.
     *
     * @see #getControlledSquaresForPieceAt(Square)
     */
    private SquareSet getSuperficialControlledSquaresFor(Color color) {
        Objects.requireNonNull(color);
        SquareSet set = new SquareSet();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece == null)
                    continue;
                if (piece.getColor() != color)
                    continue;
                set = set.union(getControlledSquaresForPieceAt(new Square(j, i)));
            }
        }
        return set;
    }

    private void updateSetForMovesInDirection(SquareSet set, Square start, int deltaR, int deltaF, int limit, boolean allowCaptures) {
        int rank = start.getRank();
        int file = start.getFile();
        for (int i = 0; i < limit; i++) {
            rank += deltaR;
            file += deltaF;
            Square sq;
            try {
                sq = new Square(file, rank);
            } catch (IllegalArgumentException e) {
                // Return once the square is out of bounds
                return;
            }
            Piece piece = get(sq);
            if (piece == null) {
                set.add(sq);
            } else {
                if (allowCaptures)
                    set.add(sq);
                return;
            }
        }
    }

    /**
     * Get all available, legal moves for the color to move.
     */
    public HashMap<Square, SquareSet> getAvailableMoves() {
        HashMap<Square, SquareSet> result = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square sq = new Square(j, i);
                SquareSet set = getAvailableMovesForPieceAt(sq);
                if (!set.isEmpty())
                    result.put(sq, set);
            }
        }
        return result;
    }

    /**
     * Find the king of the specific color.
     */
    private Square findKing(Color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece p = board[i][j];
                if (p != null && p.getRole() == Role.KING && p.getColor() == color)
                    return new Square(j, i);
            }
        }
        throw new IllegalStateException("No king found for color " + color);
    }

    /**
     * Return whether the given color's king is in check.
     */
    private boolean isInCheck(Color color) {
        return getSuperficialControlledSquaresFor(color.other()).contains(findKing(color));
    }

    /**
     * Resign the game.
     */
    public void resign() {
        if (termination != null)
            throw new IllegalStateException("Game already ended");
        termination = Termination.winByResignation(colorToMove.other());
    }

    private void calculateTermination() {
        boolean check = isInCheck(colorToMove);
        boolean hasMoves = !getAvailableMoves().isEmpty();
        if (check && !hasMoves) {
            termination = Termination.winByCheckmate(colorToMove.other());
        } else if (!check && !hasMoves) {
            termination = Termination.DRAW_STALEMATE;
        } else if (semiMovesSinceLastPawnMoveOrCapture >= 100) {
            termination = Termination.DRAW_FIFTY_MOVE;
        } else {
            termination = null;
        }
    }

    public Termination getTermination() {
        return termination;
    }

    @Override
    public String toString() {
        return toString(false, false);
    }

    public String toString(boolean unicode, boolean labels) {
        StringBuilder s = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (j != 0)
                    s.append(' ');
                if (board[i][j] == null) {
                    s.append('.');
                } else {
                    s.append(unicode ? board[i][j].getUnicodeSymbol() : board[i][j].getSymbol());
                }
            }
            if (labels) {
                s.append("  ");
                s.append(i + 1);
            }
            if (i != 0)
                s.append('\n');
        }
        if (labels)
            s.append("\n\na b c d e f g h");
        return s.toString();
    }

    /**
     * Sign (or signum) function.
     *
     * @return -1 if i is negative, 1 if i is positive, or 0 if i is zero.
     */
    private static int sgn(int i) {
        return Integer.compare(i, 0);
    }
}
