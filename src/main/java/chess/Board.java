package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private ArrayList<Pawn> pawns;

    public Board() {
        this.pawns = new ArrayList<>();
    }

    public void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }

    public Pawn getPawn(int index) {
        return pawns.get(index);
    }

    public int getNumberOfPieces() {
        return pawns.size();
    }
}
