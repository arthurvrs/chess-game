package chess.pieces;

import static java.lang.Character.toUpperCase;
import util.Character;

public abstract class Piece {

    public enum Color {black, white, blank}
    protected final Color color;
    protected char representation;
    protected double strength;
    protected String location;
    public enum Movement {
        up, left, down, right,
        upLeft, upRight, downLeft, downRight,
        upUpLeft, leftLeftUp, leftLeftDown, downDownLeft,
        downDownRight, rightRightDown, rightRightUp, upUpRight
    }

    protected Piece(Color color, char representation) {
        this.color = color;

        if(isBlack())
            this.representation = toUpperCase(representation);
        else if (isWhite())
            this.representation = representation;
        else
            this.representation = '.';

    }

    public Color getColor() {
        return color;
    }

    public boolean isBlack() {
        return color == Color.black;
    }

    public boolean isWhite() {
        return color == Color.white;
    }

    public char getRepresentation() {
        return representation;
    }

    public double getStrength() {
        return strength;
    }

    public abstract boolean getPossibleMoves(Movement movement);

    public abstract int getNumberOfMoves();

    public String getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = Character.getLocation(location);
    }
}