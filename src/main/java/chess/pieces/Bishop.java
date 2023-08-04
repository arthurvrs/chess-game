package chess.pieces;

public class Bishop extends Piece {

    private Bishop(Color color) {
        super(color, 'b');
        strength = 3.0;
    }

    public static Piece createPiece(Color color) {
        return new Bishop(color);
    }

    @Override
    public boolean getPossibleMoves(Movement movement) {
        return true;
    }

    @Override
    public int getNumberOfMoves() {
        return 7;
    }
}
