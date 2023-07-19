package chess.pieces;

import java.util.*;

public class Pawn {

    private String color;

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn() {
        this.color = "white";
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public String getRepresentation() {
        if(this.color.equals("black")) {
            return "P";
        }
        return "p";
    }

}
