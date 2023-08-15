package chess;

import chess.pieces.*;
import util.*;

import java.util.ArrayList;

public class Board {

    private final Piece[][] board;
    private final ArrayList<Piece> defaultWhitePieces;
    private final ArrayList<Piece> orderedWhitePieces;
    private final ArrayList<Piece> defaultBlackPieces;
    private final ArrayList<Piece> orderedBlackPieces;

    public Board() {
        board = new Piece[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = Blank.createPiece();
                board[i][j].setLocation(new int[]{i, j});
            }
        }
        this.defaultWhitePieces = new ArrayList<>();
        this.orderedWhitePieces = new ArrayList<>();

        this.defaultBlackPieces = new ArrayList<>();
        this.orderedBlackPieces = new ArrayList<>();

    }

    public void initialize() {
        createWhitePieces();
        setPiecesInLines(board, defaultWhitePieces, 6, 7);

        createBlackPieces();
        setPiecesInLines(board, defaultBlackPieces, 0, 1);
    }
    private void setPiecesInLines(Piece[][] board, ArrayList<Piece> pieces, int firstColumn, int secondColumn) {
        int aux = 0;
        for(int i = firstColumn; i <= secondColumn; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = pieces.get(j + aux);
                board[i][j].setLocation(new int[]{i, j});
            }
            aux = 8;
        }
    }
    private void createWhitePieces() {
        addWhitePawns();
        addWhiteOtherPieces(Rook.createPiece(Piece.Color.white));
        addWhiteOtherPieces(Knight.createPiece(Piece.Color.white));
        addWhiteOtherPieces(Bishop.createPiece(Piece.Color.white));
        addWhiteOtherPieces(Queen.createPiece(Piece.Color.white));
        addWhiteOtherPieces(King.createPiece(Piece.Color.white));
        addWhiteOtherPieces(Bishop.createPiece(Piece.Color.white));
        addWhiteOtherPieces(Knight.createPiece(Piece.Color.white));
        addWhiteOtherPieces(Rook.createPiece(Piece.Color.white));
    }
    private void addWhiteOtherPieces(Piece piece) {
        defaultWhitePieces.add(piece);
        orderedWhitePieces.add(piece);
        orderStrength(orderedWhitePieces);
    }
    private void addWhitePawns() {
        for(int i = 0; i < 8; i++) {
            addWhiteOtherPieces(Pawn.createPiece(Piece.Color.white));
        }
    }
    private void createBlackPieces() {
        addBlackOtherPieces(Rook.createPiece(Piece.Color.black));
        addBlackOtherPieces(Knight.createPiece(Piece.Color.black));
        addBlackOtherPieces(Bishop.createPiece(Piece.Color.black));
        addBlackOtherPieces(Queen.createPiece(Piece.Color.black));
        addBlackOtherPieces(King.createPiece(Piece.Color.black));
        addBlackOtherPieces(Bishop.createPiece(Piece.Color.black));
        addBlackOtherPieces(Knight.createPiece(Piece.Color.black));
        addBlackOtherPieces(Rook.createPiece(Piece.Color.black));
        addBlackPawns();
    }
    private void addBlackOtherPieces(Piece piece) {
        defaultBlackPieces.add(piece);
        orderedBlackPieces.add(piece);
        orderStrength(orderedBlackPieces);
    }
    private void addBlackPawns() {
        for(int i = 0; i < 8; i++) {
            addBlackOtherPieces(Pawn.createPiece(Piece.Color.black));
        }
    }
    private void orderStrength(ArrayList<Piece> pieces) {
        int aux = pieces.size() - 1;
        Piece piece;
        for(int i = pieces.size() - 2; i >= 0; i--) {
            if(pieces.get(aux).getStrength() > pieces.get(i).getStrength()) {
                piece = pieces.get(i);
                pieces.set(i, pieces.get(aux));
                pieces.set(aux, piece);
            }
            aux--;
        }
    }

    public String getOrderStrength(Piece.Color color) {
        StringBuilder list = new StringBuilder();
        if(color == Piece.Color.black) {
            for (Piece orderedBlackPiece : orderedBlackPieces) {
                list.append(orderedBlackPiece.getRepresentation());
                list.append("\n");
            }
        } else {
            for (Piece orderedWhitePiece : orderedWhitePieces) {
                list.append(orderedWhitePiece.getRepresentation());
                list.append(StringUtil.getNEWLINE());
            }
        }
        return list.toString();
    }

    public Piece[][] getBoard() {
        return board;
    }

    public int getNumberOfPieces() {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j].getRepresentation() != '.') {
                    count++;
                }
            }
        }
        return count;
    }

    public int getNumberOfSpecificsPieces(char representation) {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j].getRepresentation() == representation) {
                    count++;
                }
            }
        }
        return count;
    }

    public int[] getPieceLocation(char representation) {
        int[] aux = new int[2];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j].getRepresentation() == representation) {
                    aux[0] = i;
                    aux[1] = j;
                    return aux;
                }
            }
        }
        return aux;
    }

    public Piece getPieceAtLocation(String location) {
        int [] aux = getRightLocation(location);
        return board[aux[0]][aux[1]];
    }
    private int[] getRightLocation(String location) {
        return util.Character.getLocation(location);
    }

    public void setPieceAtLocation(Piece.Color color, String type, String location) {
        if(color == Piece.Color.black) {
            switch (type) {
                case "pawn" -> setBlackPiece(Pawn.createPiece(color), location);
                case "rook" -> setBlackPiece(Rook.createPiece(color), location);
                case "knight" -> setBlackPiece(Knight.createPiece(color), location);
                case "bishop" -> setBlackPiece(Bishop.createPiece(color), location);
                case "queen" -> setBlackPiece(Queen.createPiece(color), location);
                case "king" -> setBlackPiece(King.createPiece(color), location);
            }
        } else if(color == Piece.Color.white){
            switch (type) {
                case "pawn" -> setWhitePiece(Pawn.createPiece(color), location);
                case "rook" -> setWhitePiece(Rook.createPiece(color), location);
                case "knight" -> setWhitePiece(Knight.createPiece(color), location);
                case "bishop" -> setWhitePiece(Bishop.createPiece(color), location);
                case "queen" -> setWhitePiece(Queen.createPiece(color), location);
                case "king" -> setWhitePiece(King.createPiece(color), location);
            }
        } else {
            setBlankPiece(Blank.createPiece(), location);
        }
    }
    private void setBlankPiece(Piece piece, String location) {
        int [] aux = getRightLocation(location);
        board[aux[0]][aux[1]] = piece;
        board[aux[0]][aux[1]].setLocation(new int[]{aux[0], aux[1]});
    }
    private void setBlackPiece(Piece piece, String location) {
        this.defaultBlackPieces.add(piece);
        this.orderedBlackPieces.add(piece);
        orderStrength(orderedBlackPieces);
        int [] aux = getRightLocation(location);
        board[aux[0]][aux[1]] =
                this.defaultBlackPieces.
                        get(this.defaultBlackPieces.size()-1);
        board[aux[0]][aux[1]].setLocation(new int[]{aux[0], aux[1]});
    }
    private void setWhitePiece(Piece piece, String location) {
        this.defaultWhitePieces.add(piece);
        this.orderedWhitePieces.add(piece);
        orderStrength(orderedWhitePieces);
        int [] aux = getRightLocation(location);
        board[aux[0]][aux[1]] =
                this.defaultWhitePieces.
                        get(this.defaultWhitePieces.size()-1);
        board[aux[0]][aux[1]].setLocation(new int[]{aux[0], aux[1]});
    }

    public String print() {
        StringBuilder boardPrintable = new StringBuilder();

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                boardPrintable.append(board[i][j].getRepresentation());
            }
            boardPrintable.append(StringUtil.getNEWLINE());
        }
        return boardPrintable.toString();
    }

    public double getPiecesStrength(Piece.Color color) {
        return getStrength(color);
    }
    private double getStrength(Piece.Color color) {
        double strength = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j].getColor() == color) {
                    if(board[i][j].getClass() == Pawn.class && searchPawnInFile(i, j)) {
                        strength -= 1;
                    }
                    strength += board[i][j].getStrength();
                }
            }
        }
        return strength;
    }

    private boolean searchPawnInFile(int rankIndex, int fileIndex) {
        for(int i = rankIndex + 1; i < 8; i++) {
            if(board[rankIndex][fileIndex].getClass() == Pawn.class && board[i][fileIndex].getClass() == Pawn.class) {
                return true;
            }
        }
        return false;
    }

}