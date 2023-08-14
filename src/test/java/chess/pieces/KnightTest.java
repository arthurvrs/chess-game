package chess.pieces;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest extends TestCase {

    public void testGetPossibleMoves() {
        Piece piece = Knight.createPiece(Piece.Color.black);
        assertTrue(piece.getPossibleMoves(Piece.Movement.upUpLeft));
        assertTrue(piece.getPossibleMoves(Piece.Movement.leftLeftUp));
        assertTrue(piece.getPossibleMoves(Piece.Movement.leftLeftDown));
        assertTrue(piece.getPossibleMoves(Piece.Movement.downDownLeft));
        assertTrue(piece.getPossibleMoves(Piece.Movement.downDownRight));
        assertTrue(piece.getPossibleMoves(Piece.Movement.rightRightDown));
        assertTrue(piece.getPossibleMoves(Piece.Movement.rightRightUp));
        assertTrue(piece.getPossibleMoves(Piece.Movement.upUpRight));

        assertFalse(piece.getPossibleMoves(Piece.Movement.up));
        assertFalse(piece.getPossibleMoves(Piece.Movement.left));
        assertFalse(piece.getPossibleMoves(Piece.Movement.down));
        assertFalse(piece.getPossibleMoves(Piece.Movement.right));
    }

}