package chess.pieces;

public class Blank extends Piece {

    private Blank() {
        super(Color.blank, '.');
        strength = 0.0;
    }

    public static Piece createPiece() {
        return new Blank();
    }

}
