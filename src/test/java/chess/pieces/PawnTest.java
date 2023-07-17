package chess.pieces;

import chess.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para os Peões.
 */
class PawnTest {

    /**
     * Método para testar a criação de peões.
     */
    @Test
    public void testCreate() {
        final String firstPawnColor = "white";
        Pawn pawn = new Pawn(firstPawnColor);
        assertEquals(firstPawnColor, pawn.getColor());

        final String secondPawnColor = "black";
        Pawn secondPawn = new Pawn(secondPawnColor);
        assertEquals(secondPawnColor, secondPawn.getColor());
    }

    /**
     * Método para testar o controlador sem parâmetro.
     */
    @Test
    public void defaultPawnColor() {
        Pawn pawn = new Pawn();
        assertEquals("white", pawn.getColor());
    }
}