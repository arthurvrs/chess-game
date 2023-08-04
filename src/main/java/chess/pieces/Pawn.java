package chess.pieces;

public class Pawn extends Piece {

    private Pawn(Color color) {
        super(color, 'p');
        strength = 1.0;
    }

    public static Piece createPiece(Color color) {
        return new Pawn(color);
    }

    public void deprecatePawn() {
        strength -= 0.5;
    }

}
