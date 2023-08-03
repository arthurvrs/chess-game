package chess.pieces;

import java.util.*;

import static java.lang.Character.toUpperCase;

public class Piece {

    private final Color color;
    public enum Color {black, white, blank}
    private Map<Piece.Type, Double> strengthMap;
    //private final char representation;
    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');
        private final char representation;
        Type(char representation) {
            this.representation = representation;
        }
        char getRepresentation() {
            return representation;
        }
    }

    private final Type type;

    private Piece(Color color, Type type) {
        if(color == Color.black) {
            this.color = Color.black;
            this.type = type;
        } else if (color == Color.white){
            this.color = Color.white;
            this.type = type;
        } else {
            this.color = Color.blank;
            this.type = type;
        }
    }

    public static Piece noPiece() {
        return new Piece(null, Type.NO_PIECE);
    }

    public static Piece createBlackPiece(Type type) {
        return new Piece(Color.black, type);
    }

    public static Piece createWhitePiece(Type type) {
        return new Piece(Color.white, type);
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        if (color == Color.black)
            return toUpperCase(getType().getRepresentation());
        return getType().getRepresentation();
    }

    public boolean isBlack() {
        return color == Color.black;
    }

    public boolean isWhite() {
        return color == Color.white;
    }

    public double getStrength() {
        return getStrengths().get(this.getType());
    }

    private Map<Type, Double> getStrengths() {
        if(strengthMap == null) {
            loadStrengths();
        }
        return strengthMap;
    }

    private void loadStrengths() {
        strengthMap = new EnumMap<>(Piece.Type.class);
        strengthMap.put(Type.NO_PIECE, 0.0);
        strengthMap.put(Type.KING, 0.0);
        strengthMap.put(Type.PAWN, 1.0);
        strengthMap.put(Type.KNIGHT, 2.5);
        strengthMap.put(Type.BISHOP, 3.0);
        strengthMap.put(Type.ROOK, 5.0);
        strengthMap.put(Type.QUEEN, 9.0);
    }
}