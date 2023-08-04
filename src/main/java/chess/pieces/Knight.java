package chess.pieces;

public class Knight extends Piece {

    private Knight(Color color) {
        super(color, 'n');
        strength = 2.5;
    }

    public static Piece createPiece(Color color) {
        return new Knight(color);
    }
}
