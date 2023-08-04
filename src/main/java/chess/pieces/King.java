package chess.pieces;

public class King extends Piece {

    private King(Color color) {
        super(color, 'k');
        strength = 0.0;
    }

    public static Piece createPiece(Color color) {
        return new King(color);
    }
}
