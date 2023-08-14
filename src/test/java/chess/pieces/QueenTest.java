package chess.pieces;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class QueenTest extends TestCase {

    public void testGetPossibleMoves() {
        Piece piece = Queen.createPiece(Piece.Color.black);
        assertTrue(piece.getPossibleMoves(Piece.Movement.up));
        assertTrue(piece.getPossibleMoves(Piece.Movement.upLeft));
        assertTrue(piece.getPossibleMoves(Piece.Movement.left));
        assertTrue(piece.getPossibleMoves(Piece.Movement.downLeft));
        assertTrue(piece.getPossibleMoves(Piece.Movement.down));
        assertTrue(piece.getPossibleMoves(Piece.Movement.downRight));
        assertTrue(piece.getPossibleMoves(Piece.Movement.right));
        assertTrue(piece.getPossibleMoves(Piece.Movement.upRight));

        assertFalse(piece.getPossibleMoves(Piece.Movement.downDownLeft));
        assertFalse(piece.getPossibleMoves(Piece.Movement.rightRightUp));
    }

}