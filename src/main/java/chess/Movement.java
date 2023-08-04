package chess;

import chess.pieces.Blank;
import chess.pieces.Piece;

public class Movement {

    private static final Piece auxPiece = Blank.createPiece();

    public static void moveUp(Board board, int[] location) {
        board.getBoard()[location[0] - 1][location[1]] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveUpLeft(Board board, int[] location) {
        board.getBoard()[location[0] - 1][location[1] - 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveUpUpLeft(Board board, int[] location) {
        board.getBoard()[location[0] - 2][location[1] - 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveLeftLeftUp(Board board, int[] location) {
        board.getBoard()[location[0] - 1][location[1] - 2] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveLeft(Board board, int[] location) {
        board.getBoard()[location[0]][location[1] - 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveLeftLeftDown(Board board, int[] location) {
        board.getBoard()[location[0] + 1][location[1] - 2] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveDownDownLeft(Board board, int[] location) {
        board.getBoard()[location[0] + 2][location[1] - 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveDownLeft(Board board, int[] location) {
        board.getBoard()[location[0] + 1][location[1] - 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveDown(Board board, int[] location) {
        board.getBoard()[location[0] + 1][location[1]] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveDownDownRight(Board board, int[] location) {
        board.getBoard()[location[0] + 2][location[1] + 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveRightRightDown(Board board, int[] location) {
        board.getBoard()[location[0] + 1][location[1] + 2] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveDownRight(Board board, int[] location) {
        board.getBoard()[location[0] + 1][location[1] + 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
        public static void moveRight(Board board, int[] location) {
        board.getBoard()[location[0]][location[1] + 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveRightRightUp(Board board, int[] location) {
        board.getBoard()[location[0] - 1][location[1] + 2] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveUpRight(Board board, int[] location) {
        board.getBoard()[location[0] - 1][location[1] + 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }
    public static void moveUpUpRight(Board board, int[] location) {
        board.getBoard()[location[0] - 2][location[1] + 1] = board.getBoard()[location[0]][location[1]];
        board.getBoard()[location[0]][location[1]] = auxPiece;
    }

}
