package chess;

import chess.pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;

public class Board {

    private String[][] board;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;

    public Board() {
        board = new String[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = ".";
            }
        }
        this.blackPieces = createPieces("black");
        this.whitePieces = createPieces("white");
    }

    private ArrayList<Piece> createPieces(String color) {
        ArrayList<Piece> pieces = new ArrayList<>();
        if(color.equals("white")) {
            addPawn(pieces, color);
        }
        pieces.add(Piece.create(color, "rook"));
        pieces.add(Piece.create(color, "nightsK"));
        pieces.add(Piece.create(color, "bishop"));
        pieces.add(Piece.create(color, "queen"));
        pieces.add(Piece.create(color, "king"));
        pieces.add(Piece.create(color, "bishop"));
        pieces.add(Piece.create(color, "nightsK"));
        pieces.add(Piece.create(color, "rook"));
        if(color.equals("black")) {
            addPawn(pieces, color);
        }

        return pieces;
    }

    private void addPawn(ArrayList<Piece> pieces, String color) {
        for(int i = 0; i < 8; i++) {
            pieces.add(Piece.create(color, "pawn"));
        }
    }

    public void initialize() {
        setPiecesInLines(board, blackPieces, 0, 1);
        setPiecesInLines(board, whitePieces, 6, 7);
    }

    private void setPiecesInLines(String[][] board, ArrayList<Piece> pieces, int firstColumn, int secondColumn) {
        int aux = 0;
        for(int i = firstColumn; i <= secondColumn; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = pieces.get(j + aux).getRepresentation();
            }
            aux = 8;
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public String print() {
        StringBuilder boardPrintable = new StringBuilder();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                boardPrintable.append(board[i][j]);
            }
            boardPrintable.append(StringUtil.getNEWLINE());
        }
        return boardPrintable.toString();
    }

    /*public Piece getPawn(int index) {
        return pawns.get(index);
    }*/

    public int getNumberOfPieces() {
        return Piece.COUNT;
    }
}
