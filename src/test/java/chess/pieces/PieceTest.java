package chess.pieces;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes para os Peões.
 */
public class PieceTest extends TestCase {

    private Piece firstPiece;
    private Piece secondPiece;
    public static final String white = "white";
    public static final String black = "black";

    public PieceTest() {
        firstPiece = Piece.create("white", "pawn");
        secondPiece = Piece.create("black", "pawn");
    }
    /**
     * Método para testar a criação de peões.
     */
    @Test
    public void testCreate() {
        assertEquals(white, firstPiece.getColor());
        assertEquals("pawn", firstPiece.getName());
        assertEquals(black, secondPiece.getColor());
        assertEquals("pawn", secondPiece.getName());
    }

    @Test
    public void testIsBlack() {
        assertTrue(secondPiece.isBlack());
        assertFalse(secondPiece.isWhite());
    }

    @Test
    public void testIsWhite() {
        assertTrue(firstPiece.isWhite());
        assertFalse(firstPiece.isBlack());
    }

}