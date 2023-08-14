package chess.pieces;

import junit.framework.TestCase;

public class RookTest extends TestCase {

    public void testGetPossibleMoves() {
        Piece piece = Rook.createPiece(Piece.Color.white);
        assertTrue(piece.getPossibleMoves(Piece.Movement.up));
        assertTrue(piece.getPossibleMoves(Piece.Movement.left));
        assertTrue(piece.getPossibleMoves(Piece.Movement.down));
        assertTrue(piece.getPossibleMoves(Piece.Movement.right));

        assertFalse(piece.getPossibleMoves(Piece.Movement.downLeft));
        assertFalse(piece.getPossibleMoves(Piece.Movement.upRight));
        assertFalse(piece.getPossibleMoves(Piece.Movement.rightRightDown));
        assertFalse(piece.getPossibleMoves(Piece.Movement.upLeft));
    }

}