package chess.pieces;

public class King extends Piece {

    private King(Color color) {
        super(color, 'k');
        strength = 0.0;
    }

    public static Piece createPiece(Color color) {
        return new King(color);
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
        return 1;
    }
}
