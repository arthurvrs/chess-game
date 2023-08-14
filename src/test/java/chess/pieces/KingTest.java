package chess.pieces;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest extends TestCase {

    public void testGetPossibleMoves() {
        Piece piece = King.createPiece(Piece.Color.white);
        assertTrue(piece.getPossibleMoves(Piece.Movement.up));
        assertTrue(piece.getPossibleMoves(Piece.Movement.left));
        assertTrue(piece.getPossibleMoves(Piece.Movement.down));
        assertTrue(piece.getPossibleMoves(Piece.Movement.right));

        assertFalse(piece.getPossibleMoves(Piece.Movement.downLeft));
        assertFalse(piece.getPossibleMoves(Piece.Movement.upRight));
    }

}