package chess.pieces;

public class Queen extends Piece {

    private Queen(Color color) {
        super(color, 'q');
        strength = 9.0;
    }

    public static Piece createPiece(Color color) {
        return new Queen(color);
    }
}
