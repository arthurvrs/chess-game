package chess.pieces;

public class Queen extends Piece {

    private Queen(Color color) {
        super(color, 'q');
        strength = 9.0;
    }

    public static Piece createPiece(Color color) {
        return new Queen(color);
    }

    @Override
    public boolean getPossibleMoves(Movement movement) {
        return
                movement == Movement.up ||
                movement == Movement.upLeft ||
                movement == Movement.left ||
                movement == Movement.downLeft ||
                movement == Movement.down ||
                movement == Movement.downRight ||
                movement == Movement.right ||
                movement == Movement.upRight;
    }

    @Override
    public int getNumberOfMoves() {
        return 7;
    }
}
