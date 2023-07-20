package chess.pieces;

public class Piece {

    private final String color;
    private final String name;

    public static int COUNT;

    private Piece(String color, String name) {
        this.color = color;
        this.name = name;
        COUNT++;
    }

    public static Piece create(String color, String name) {
        return new Piece(color, name);
    }

    public String getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public static void resetCOUNT() {
        COUNT = 0;
    }

    public static int getCOUNT() {
        return COUNT;
    }

    public String getRepresentation() {
        if(this.color.equals("black")) {
            return firstPieceLetter(name).toUpperCase();
        }
        return firstPieceLetter(name).toLowerCase();
    }

    private String firstPieceLetter(String name) {
        return name.substring(0,1);
    }

    public boolean isBlack() {
        return color.equals("black");
    }

    public boolean isWhite() {
        return color.equals("white");
    }

}
