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
            addWhitePieces(Piece.ROOK_REPRESENTATION);
            addWhitePieces(Piece.KNIGHT_REPRESENTATION);
            addWhitePieces(Piece.BISHOP_REPRESENTATION);
            addWhitePieces(Piece.QUEEN_REPRESENTATION);
            addWhitePieces(Piece.KING_REPRESENTATION);
            addWhitePieces(Piece.BISHOP_REPRESENTATION);
            addWhitePieces(Piece.KNIGHT_REPRESENTATION);
            addWhitePieces(Piece.ROOK_REPRESENTATION);
        }

        if(color == Piece.Color.black) {
            addBlackPieces(Piece.ROOK_REPRESENTATION);
            addBlackPieces(Piece.KNIGHT_REPRESENTATION);
            addBlackPieces(Piece.BISHOP_REPRESENTATION);
            addBlackPieces(Piece.QUEEN_REPRESENTATION);
            addBlackPieces(Piece.KING_REPRESENTATION);
            addBlackPieces(Piece.BISHOP_REPRESENTATION);
            addBlackPieces(Piece.KNIGHT_REPRESENTATION);
            addBlackPieces(Piece.ROOK_REPRESENTATION);
            addBlackPawns();
        }
    }

    private void addBlackPieces(char representation) {
        defaultBlackPieces.add(Piece.createBlackPiece(representation));
        orderedBlackPieces.add(Piece.createBlackPiece(representation));
        orderStrength(orderedBlackPieces);
    }

    private void addBlackPawns() {
        for(int i = 0; i < 8; i++) {
            addBlackPieces(Piece.PAWN_REPRESENTATION);
        }
    }

    private void addWhitePieces(char representation) {
        defaultWhitePieces.add(Piece.createWhitePiece(representation));
        orderedWhitePieces.add(Piece.createWhitePiece(representation));
        orderStrength(orderedWhitePieces);
    }

    private void addWhitePawns() {
        for(int i = 0; i < 8; i++) {
            addWhitePieces(Piece.PAWN_REPRESENTATION);
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
            if(pieces.get(aux).getStrengh() > pieces.get(i).getStrengh()) {
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
            for(int i = 0; i < orderedBlackPieces.size(); i++) {
                list.append(orderedBlackPieces.get(i).getRepresentation());
                list.append("\n");
            }
        } else {
            for(int i = 0; i < orderedWhitePieces.size(); i++) {
                list.append(orderedWhitePieces.get(i).getRepresentation());
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
        int [] aux = util.Character.getLocation(location);
        int rank = aux[0];
        int files = aux[1];
        return aux;
    }

    public void setPieceAtLocation(Piece.Color color, char representation, String location) {
        if(color == Piece.Color.black) {
            this.defaultBlackPieces.add(Piece.createBlackPiece(representation));
            this.orderedBlackPieces.add(Piece.createBlackPiece(representation));
            orderStrength(orderedBlackPieces);
            int [] aux = getRightLocation(location);
            board[aux[0]][aux[1]] =
                    this.defaultBlackPieces.
                    get(this.defaultBlackPieces.size()-1);
        } else {
            this.defaultWhitePieces.add(Piece.createWhitePiece(representation));
            this.orderedWhitePieces.add(Piece.createWhitePiece(representation));
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
        double strength;
        if(color == Piece.Color.black) {
            strength = getStrength(color);
        } else {
            strength = getStrength(color);
        }
        return strength;
    }

    private double getStrength(Piece.Color color) {
        double strengh = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j].getColor() == color) {
                    if(board[i][j].getType() == Piece.Type.PAWN) {
                        searchPawnInFile(i, j);
                    }
                    strengh += board[i][j].getStrengh();
                }
            }
        }
        return strengh;
    }

    /**
     * Checar futuramente para ver se não está dando problema no depricatePawn() com um IndexOutOfBoundsException na matriz.
     * @param rankIndex
     * @param fileIndex
     */
    private void searchPawnInFile(int rankIndex, int fileIndex) {
        for(int i = rankIndex + 1; i < 8; i++) {
            if(board[rankIndex][fileIndex].getType() == board[i][fileIndex].getType()) {
                board[rankIndex][fileIndex].depricatePawn();
                board[i][fileIndex].depricatePawn();
                break;
            }
        }
    }

}
