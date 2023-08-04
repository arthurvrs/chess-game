package chess.pieces;

public class Blank extends Piece {

    private Blank() {
        super(Color.blank, '.');
        strength = 0.0;
    }

    public static Piece createPiece() {
        return new Blank();
    }

    @Override
    public boolean getPossibleMoves(Movement movement) {
        return false;
    }

    @Override
    public int getNumberOfMoves() {
        return 0;
    }
}
