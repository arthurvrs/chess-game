package chess.pieces;

import junit.framework.TestCase;

public class PawnTest extends TestCase {

    public void testGetPossibleMoves() {
        Piece pieceWhite = Pawn.createPiece(Piece.Color.white);
        assertTrue(pieceWhite.getPossibleMoves(Piece.Movement.up));
        assertTrue(pieceWhite.getPossibleMoves(Piece.Movement.upLeft));
        assertTrue(pieceWhite.getPossibleMoves(Piece.Movement.upRight));

        Piece pieceBlack = Pawn.createPiece(Piece.Color.black);
        assertTrue(pieceBlack.getPossibleMoves(Piece.Movement.downLeft));
        assertTrue(pieceBlack.getPossibleMoves(Piece.Movement.down));
        assertTrue(pieceBlack.getPossibleMoves(Piece.Movement.downRight));

        assertFalse(pieceWhite.getPossibleMoves(Piece.Movement.down));
        assertFalse(pieceWhite.getPossibleMoves(Piece.Movement.downLeft));
        assertFalse(pieceWhite.getPossibleMoves(Piece.Movement.downRight));
        assertFalse(pieceBlack.getPossibleMoves(Piece.Movement.up));
        assertFalse(pieceBlack.getPossibleMoves(Piece.Movement.upLeft));
        assertFalse(pieceBlack.getPossibleMoves(Piece.Movement.upRight));

        assertFalse(pieceWhite.getPossibleMoves(Piece.Movement.leftLeftDown));
        assertFalse(pieceBlack.getPossibleMoves(Piece.Movement.upUpLeft));
    }
}