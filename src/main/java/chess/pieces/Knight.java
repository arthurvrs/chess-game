package chess.pieces;

public class Knight extends Piece {

    private Knight(Color color) {
        super(color, 'n');
        strength = 2.5;
    }

    public static Piece createPiece(Color color) {
        return new Knight(color);
    }

    @Override
    public boolean getPossibleMoves(Movement movement) {
        return
                movement == Movement.upUpLeft ||
                movement == Movement.leftLeftUp ||
                movement == Movement.leftLeftDown ||
                movement == Movement.downDownLeft ||
                movement == Movement.downDownRight ||
                movement == Movement.rightRightDown ||
                movement == Movement.rightRightUp ||
                movement == Movement.upUpRight;
    }

    @Override
    public int getNumberOfMoves() {
        return 1;
    }
}
