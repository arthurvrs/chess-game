package chess.pieces;

import junit.framework.TestCase;

import static java.lang.Character.toUpperCase;

/**
 * Classe de testes para os Peões.
 */
public class PieceTest extends TestCase {

    /**
     * Método para testar a criação de peões.
     */
    public void testCreate() {
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.PAWN), Piece.createBlackPiece(Piece.Type.PAWN),
                Piece.Type.PAWN);
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.ROOK), Piece.createBlackPiece(Piece.Type.ROOK),
                Piece.Type.ROOK);
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.KNIGHT), Piece.createBlackPiece(Piece.Type.KNIGHT),
                Piece.Type.KNIGHT);
        verifyCreation(
                Piece.createWhitePiece(Piece.Type.BISHOP), Piece.createBlackPiece(Piece.Type.BISHOP),
                Piece.Type.BISHOP);
        verifyCreation(Piece.createWhitePiece(Piece.Type.QUEEN), Piece.createBlackPiece(Piece.Type.QUEEN),
                Piece.Type.QUEEN);
        verifyCreation(Piece.createWhitePiece(Piece.Type.KING), Piece.createBlackPiece(Piece.Type.KING),
                Piece.Type.KING);
        Piece blank = Piece.noPiece();
        assertEquals('.', blank.getRepresentation());
        assertEquals(Piece.Type.NO_PIECE, blank.getType());
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(type.getRepresentation(), whitePiece.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(toUpperCase(type.getRepresentation()), blackPiece.getRepresentation());

    }

    public void testGetStrengh() {
        Piece blackQueen = Piece.createBlackPiece(Piece.Type.QUEEN);
        assertEquals(9.0, blackQueen.getStrength());
        Piece whiteBishop = Piece.createWhitePiece(Piece.Type.BISHOP);
        assertEquals(3.0, whiteBishop.getStrength());
        Piece blackPawn = Piece.createBlackPiece(Piece.Type.PAWN);
        assertEquals(1.0, blackPawn.getStrength());
        Piece whiteKnight = Piece.createWhitePiece(Piece.Type.KNIGHT);
        assertEquals(2.5, whiteKnight.getStrength());
        Piece whiteRook = Piece.createWhitePiece(Piece.Type.ROOK);
        assertEquals(5.0, whiteRook.getStrength());
    }

}