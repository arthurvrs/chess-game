package chess.pieces;

public class Bishop extends Piece {

    private Bishop(Color color) {
        super(color, 'b');
        strength = 3.0;
    }

    public static Piece createPiece(Color color) {
        return new Bishop(color);
    }
}
