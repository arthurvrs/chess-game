package chess.pieces;

import chess.pieces.Pawn;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para os Peões.
 */
public class PawnTest extends TestCase {

    public static final String white = "white";
    public static final String black = "black";
    /**
     * Método para testar a criação de peões.
     */
    @Test
    public void testCreate() {
        Pawn pawn = new Pawn(white);
        assertEquals(white, pawn.getColor());

        Pawn secondPawn = new Pawn(black);
        assertEquals(black, secondPawn.getColor());
    }

    /**
     * Método para testar o controlador sem parâmetro.
     */
    @Test
    public void testDefaultPawnColor() {
        Pawn pawn = new Pawn();
        assertEquals(white, pawn.getColor());
    }
}