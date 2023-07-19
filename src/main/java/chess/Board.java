package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;

public class Board {

    private String[][] board;
    private ArrayList<Pawn> whitePawns;
    private ArrayList<Pawn> blackPawns;

    private Character character;

    public Board() {
        board = new String[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = ".";
            }
        }
        this.whitePawns = new ArrayList<Pawn>();
        for(int i = 0; i < 8; i++) {
            whitePawns.add(new Pawn("white"));
        }
        this.blackPawns = new ArrayList<Pawn>();
        for(int i = 0; i < 8; i++) {
            blackPawns.add(new Pawn("black"));
        }

        character = new Character();
    }

    /*private void addPiece(ArrayList<> piecesType, String color, int numberOfPieces) {
        for(int i = 0; i < numberOfPieces; i++) {
            piecesType.add(new (piecesType.getClass())(color));
        }
    }*/

    public void initialize() {
        for(int i = 0; i < 8; i++) {
            board[1][i] = whitePawns.get(i).getRepresentation();
        }

        for(int i = 0; i < 8; i++) {
            board[6][i] = blackPawns.get(i).getRepresentation();
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public String toString() {
        String boardPrintable = "";

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                boardPrintable += board[i][j];
            }
            boardPrintable += character.getNEWLINE();
        }
        return boardPrintable;
    }

    /*public void addPawn(Pawn pawn) {
        pawns.add(pawn);
    }*/

    /*public Pawn getPawn(int index) {
        return pawns.get(index);
    }*/

    public int getNumberOfPieces() {
        int numberOfPieces = 0;

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(!board[i][j].equals(".")) {
                    numberOfPieces++;
                }
            }
        }

        return numberOfPieces;
    }
}
