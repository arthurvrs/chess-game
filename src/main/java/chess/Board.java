package chess;

import chess.pieces.Piece;
import util.*;

import java.util.ArrayList;

public class Board {

    private final Piece[][] board;
    private ArrayList<Piece> defaultBlackPieces;
    private ArrayList<Piece> orderedBlackPieces;
    private ArrayList<Piece> defaultWhitePieces;
    private ArrayList<Piece> orderedWhitePieces;

    public Board() {
        board = new Piece[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = Piece.noPiece();
            }
        }
        this.defaultBlackPieces = new ArrayList<>();
        this.orderedBlackPieces = new ArrayList<>();

        this.defaultWhitePieces = new ArrayList<>();
        this.orderedWhitePieces = new ArrayList<>();
    }

    private void createPieces(Piece.Color color) {
        if(color == Piece.Color.white) {
            addWhitePawns();
            addWhitePieces(Piece.Type.ROOK);
            addWhitePieces(Piece.Type.KNIGHT);
            addWhitePieces(Piece.Type.BISHOP);
            addWhitePieces(Piece.Type.QUEEN);
            addWhitePieces(Piece.Type.KING);
            addWhitePieces(Piece.Type.BISHOP);
            addWhitePieces(Piece.Type.KNIGHT);
            addWhitePieces(Piece.Type.ROOK);
        }

        if(color == Piece.Color.black) {
            addBlackPieces(Piece.Type.ROOK);
            addBlackPieces(Piece.Type.KNIGHT);
            addBlackPieces(Piece.Type.BISHOP);
            addBlackPieces(Piece.Type.QUEEN);
            addBlackPieces(Piece.Type.KING);
            addBlackPieces(Piece.Type.BISHOP);
            addBlackPieces(Piece.Type.KNIGHT);
            addBlackPieces(Piece.Type.ROOK);
            addBlackPawns();
        }
    }

    private void addWhitePieces(Piece.Type type) {
        defaultWhitePieces.add(Piece.createWhitePiece(type));
        orderedWhitePieces.add(Piece.createWhitePiece(type));
        orderStrength(orderedWhitePieces);
    }

    private void addWhitePawns() {
        for(int i = 0; i < 8; i++) {
            addWhitePieces(Piece.Type.PAWN);
        }
    }

    private void addBlackPieces(Piece.Type type) {
        defaultBlackPieces.add(Piece.createBlackPiece(type));
        orderedBlackPieces.add(Piece.createBlackPiece(type));
        orderStrength(orderedBlackPieces);
    }

    private void addBlackPawns() {
        for(int i = 0; i < 8; i++) {
            addBlackPieces(Piece.Type.PAWN);
        }
    }

    public void initialize() {
        createPieces(Piece.Color.black);
        createPieces(Piece.Color.white);
        setPiecesInLines(board, defaultBlackPieces, 0, 1);
        setPiecesInLines(board, defaultWhitePieces, 6, 7);
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

    private void setPiecesInLines(Piece[][] board, ArrayList<Piece> pieces, int firstColumn, int secondColumn) {
        int aux = 0;
        for(int i = firstColumn; i <= secondColumn; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = pieces.get(j + aux);
            }
            aux = 8;
        }
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

    public char getPieceAtLocation(String location) {
        int [] aux = getRightLocation(location);
        return board[aux[0]][aux[1]].getRepresentation();
    }

    private int[] getRightLocation(String location) {
        return util.Character.getLocation(location);
    }

    public void setPieceAtLocation(Piece.Color color, Piece.Type type, String location) {
        if(color == Piece.Color.black) {
            this.defaultBlackPieces.add(Piece.createBlackPiece(type));
            this.orderedBlackPieces.add(Piece.createBlackPiece(type));
            orderStrength(orderedBlackPieces);
            int [] aux = getRightLocation(location);
            board[aux[0]][aux[1]] =
                    this.defaultBlackPieces.
                    get(this.defaultBlackPieces.size()-1);
        } else {
            this.defaultWhitePieces.add(Piece.createWhitePiece(type));
            this.orderedWhitePieces.add(Piece.createWhitePiece(type));
            orderStrength(orderedWhitePieces);
            int [] aux = getRightLocation(location);
            board[aux[0]][aux[1]] =
                    this.defaultWhitePieces.
                    get(this.defaultWhitePieces.size()-1);
        }
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
                    if(board[i][j].getType() == Piece.Type.PAWN && searchPawnInFile(i, j)) {
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
            if(board[rankIndex][fileIndex].getType() == board[i][fileIndex].getType()) {
                return true;
            }
        }
        return false;
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

    public void moveKing(Piece.Color color, String direction) {
        int[] aux = new int[2];
        if(color == Piece.Color.black) {
            aux = getPieceLocation('K');
        } else if(color == Piece.Color.white) {
            aux = getPieceLocation('k');
        }
        Piece auxPiece = Piece.noPiece();
        switch (direction) {
            case "up":
                board[aux[0] - 1][aux[1]] = board[aux[0]][aux[1]];
                board[aux[0]][aux[1]] = auxPiece;
                break;
            case "left":
                board[aux[0]][aux[1] - 1] = board[aux[0]][aux[1]];
                board[aux[0]][aux[1]] = auxPiece;
                break;
            case "down":
                board[aux[0] + 1][aux[1]] = board[aux[0]][aux[1]];
                board[aux[0]][aux[1]] = auxPiece;
                break;
            case "right":
                board[aux[0]][aux[1] + 1] = board[aux[0]][aux[1]];
                board[aux[0]][aux[1]] = auxPiece;
                break;
        }
    }

}