package chess;

import chess.pieces.Blank;
import chess.pieces.Piece;

import static java.lang.System.in;

public class Game {

    private Board board;
    private int[] auxMovement;

    private Game() {
        board = new Board();
        auxMovement = new int[2];
    }
    public static Game startGame() {
        return new Game();
    }

    public Board getBoard() {
        return board;
    }

    public void move(String location, Piece.Movement direction, int squares) {
        Piece piece = board.getPieceAtLocation(location);
        int numberOfMoves = piece.getNumberOfMoves();
        auxMovement = board.getPieceLocation(piece.getRepresentation());
        if(squares <= numberOfMoves && piece.getPossibleMoves(direction)) {
            for(int i = 0; i < squares; i++) {
                moving(direction);
                auxMovement = board.getPieceLocation(piece.getRepresentation());
            }
        }
    }
    private void moving(Piece.Movement direction) {
        switch(direction) {
            case up -> Movement.moveUp(board, auxMovement);
            case upLeft -> Movement.moveUpLeft(board, auxMovement);
            case upUpLeft -> Movement.moveUpUpLeft(board, auxMovement);
            case leftLeftUp -> Movement.moveLeftLeftUp(board, auxMovement);
            case left -> Movement.moveLeft(board, auxMovement);
            case leftLeftDown -> Movement.moveLeftLeftDown(board, auxMovement);
            case downLeft -> Movement.moveDownLeft(board, auxMovement);
            case downDownLeft -> Movement.moveDownDownLeft(board, auxMovement);
            case down -> Movement.moveDown(board, auxMovement);
            case downDownRight -> Movement.moveDownDownRight(board, auxMovement);
            case downRight -> Movement.moveDownRight(board, auxMovement);
            case rightRightDown -> Movement.moveRightRightDown(board, auxMovement);
            case right -> Movement.moveRight(board, auxMovement);
            case rightRightUp -> Movement.moveRightRightUp(board, auxMovement);
            case upRight -> Movement.moveUpRight(board, auxMovement);
            case upUpRight -> Movement.moveUpUpRight(board, auxMovement);
        }
    }

    public void moveKing(Piece.Color color, String direction) {
        int[] aux = new int[2];
        if(color == Piece.Color.black) {
            aux = board.getPieceLocation('K');
        } else if(color == Piece.Color.white) {
            aux = board.getPieceLocation('k');
        }
        Piece auxPiece = Blank.createPiece();
        switch (direction) {
            case "up" -> {
                board.getBoard()[aux[0] - 1][aux[1]] = board.getBoard()[aux[0]][aux[1]];
                board.getBoard()[aux[0]][aux[1]] = auxPiece;
            }
            case "left" -> {
                board.getBoard()[aux[0]][aux[1] - 1] = board.getBoard()[aux[0]][aux[1]];
                board.getBoard()[aux[0]][aux[1]] = auxPiece;
            }
            case "down" -> {
                board.getBoard()[aux[0] + 1][aux[1]] = board.getBoard()[aux[0]][aux[1]];
                board.getBoard()[aux[0]][aux[1]] = auxPiece;
            }
            case "right" -> {
                board.getBoard()[aux[0]][aux[1] + 1] = board.getBoard()[aux[0]][aux[1]];
                board.getBoard()[aux[0]][aux[1]] = auxPiece;
            }
        }
    }

}
