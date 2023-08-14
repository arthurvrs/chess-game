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

    @Override
    public boolean getPossibleMoves(Movement movement) {
        if(color == Color.black) {
            return
                    movement == Movement.down ||
                    movement == Movement.downLeft ||
                    movement == Movement.downRight;
        }

        return
                movement == Movement.up ||
                movement == Movement.upLeft ||
                movement == Movement.upRight;
    }

    @Override
    public int getNumberOfMoves() {
        return 2;
    }
}
