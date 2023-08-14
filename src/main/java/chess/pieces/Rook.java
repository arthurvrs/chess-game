package chess.pieces;

public class Rook extends Piece {

    private Rook(Color color) {
        super(color, 'r');
        strength = 5.0;
    }

    public static Piece createPiece(Color color) {
        return new Rook(color);
    }

    @Override
    public boolean getPossibleMoves(Movement movement) {
        return
                movement == Movement.up ||
                movement == Movement.left ||
                movement == Movement.down ||
                movement == Movement.right;
    }

    @Override
    public int getNumberOfMoves() {
        return 7;
    }
}
