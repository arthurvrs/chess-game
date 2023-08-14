package chess.pieces;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest extends TestCase {

    public void testGetPossibleMoves() {
        Piece piece = Bishop.createPiece(Piece.Color.white);
        assertTrue(piece.getPossibleMoves(Piece.Movement.upLeft));
        assertTrue(piece.getPossibleMoves(Piece.Movement.downLeft));
        assertTrue(piece.getPossibleMoves(Piece.Movement.downRight));
        assertTrue(piece.getPossibleMoves(Piece.Movement.upRight));

        assertFalse(piece.getPossibleMoves(Piece.Movement.up));
        assertFalse(piece.getPossibleMoves(Piece.Movement.left));
        assertFalse(piece.getPossibleMoves(Piece.Movement.down));
        assertFalse(piece.getPossibleMoves(Piece.Movement.right));
    }

}