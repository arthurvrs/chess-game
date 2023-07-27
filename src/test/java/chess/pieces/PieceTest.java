package chess.pieces;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes para os Peões.
 */
public class PieceTest extends TestCase {

    /**
     * Método para testar a criação de peões.
     */
    @Test
    public void testCreate() {
        verifyCreation(
                Piece.createWhitePiece(Piece.PAWN_REPRESENTATION), Piece.createBlackPiece(Piece.PAWN_REPRESENTATION),
                Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
        verifyCreation(
                Piece.createWhitePiece(Piece.ROOK_REPRESENTATION), Piece.createBlackPiece(Piece.ROOK_REPRESENTATION),
                Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
        verifyCreation(
                Piece.createWhitePiece(Piece.KNIGHT_REPRESENTATION), Piece.createBlackPiece(Piece.KNIGHT_REPRESENTATION),
                Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
        verifyCreation(
                Piece.createWhitePiece(Piece.BISHOP_REPRESENTATION), Piece.createBlackPiece(Piece.BISHOP_REPRESENTATION),
                Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
        verifyCreation(Piece.createWhitePiece(Piece.QUEEN_REPRESENTATION), Piece.createBlackPiece(Piece.QUEEN_REPRESENTATION),
                Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
        verifyCreation(Piece.createWhitePiece(Piece.KING_REPRESENTATION), Piece.createBlackPiece(Piece.KING_REPRESENTATION),
                Piece.Type.KING, Piece.KING_REPRESENTATION);
        Piece blank = Piece.noPiece();
        assertEquals('.', blank.getRepresentation());
        assertEquals(Piece.Type.NO_PIECE, blank.getType());
    }

    private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type, char representation) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());
        assertEquals(representation, whitePiece.getRepresentation());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
        assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());

    }

    public void testGetStrengh() {
        Piece blackQueen = Piece.createBlackPiece(Piece.QUEEN_REPRESENTATION);
        assertEquals(9.0, blackQueen.getStrengh());
        Piece whiteBishop = Piece.createWhitePiece(Piece.BISHOP_REPRESENTATION);
        assertEquals(3.0, whiteBishop.getStrengh());
        Piece blackPawn = Piece.createBlackPiece(Piece.PAWN_REPRESENTATION);
        assertEquals(1.0, blackPawn.getStrengh());
        Piece whiteKnight = Piece.createWhitePiece(Piece.KNIGHT_REPRESENTATION);
        assertEquals(2.5, whiteKnight.getStrengh());
        Piece whiteRook = Piece.createWhitePiece(Piece.ROOK_REPRESENTATION);
        assertEquals(5.0, whiteRook.getStrengh());
    }

}