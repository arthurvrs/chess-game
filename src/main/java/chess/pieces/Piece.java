package chess.pieces;

public class Piece {

    private final Color color;
    public enum Color {black, white, blank}
    private double strengh;
    private final char representation;
    public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE}
    public static char PAWN_REPRESENTATION = 'p';
    public static char ROOK_REPRESENTATION = 'r';
    public static char KNIGHT_REPRESENTATION = 'n';
    public static char BISHOP_REPRESENTATION = 'b';
    public static char QUEEN_REPRESENTATION = 'q';
    public static char KING_REPRESENTATION = 'k';

    private Piece(Color color, char representation) {
        if(color == Color.black) {
            this.color = Color.black;
            this.representation = Character.toUpperCase(representation);
        } else if (color == Color.white){
            this.color = Color.white;
            this.representation = representation;
        } else {
            this.color = Color.blank;
            this.representation = representation;
        }
        setStrengh();
    }

    public static Piece noPiece() {
        return new Piece(null, '.');
    }

    public static Piece createBlackPiece(char REPRESENTATION) {
        return new Piece(Color.black, REPRESENTATION);
    }

    public static Piece createWhitePiece(char REPRESENTATION) {
        return new Piece(Color.white, REPRESENTATION);
    }

    public Type getType() {
        char auxRepresentation = Character.toLowerCase(representation);
        return switch (auxRepresentation) {
            case 'p' -> Type.PAWN;
            case 'r' -> Type.ROOK;
            case 'n' -> Type.KNIGHT;
            case 'b' -> Type.BISHOP;
            case 'q' -> Type.QUEEN;
            case 'k' -> Type.KING;
            default -> Type.NO_PIECE;
        };
    }

    public Color getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean isBlack() {
        return color == Color.black;
    }

    public boolean isWhite() {
        return color == Color.white;
    }

    private void setStrengh() {
        char auxRepresentation = Character.toLowerCase(representation);
        switch(auxRepresentation) {
            case 'p':
                this.strengh = 1;
                break;
            case 'n':
                this.strengh = 2.5;
                break;
            case 'b':
                this.strengh = 3;
                break;
            case 'r':
                this.strengh = 5;
                break;
            case 'q':
                this.strengh = 9;
                break;
        }
    }

    public void depricatePawn() {
        this.strengh -= 0.5;
    }
    public double getStrengh() {
        return this.strengh;
    }

}
