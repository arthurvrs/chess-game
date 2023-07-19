package chess;

import chess.pieces.Pawn;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para o tabuleiro.
 */
public class BoardTest extends TestCase {

    private Board board;

    public BoardTest() {
        board = new Board();
    }

    @Test
    public void testCreateBoard() {
        board.initialize();
        assertEquals(16, board.getNumberOfPieces());
        System.out.println(board.toString());
    }

    /**
     * Método que adiciona peões ao tabuleiro.
     * Adiciona um peão branco e um preto.
     */
    /*@Test
    public void testAddPawn() {
        Pawn pawn1 = new Pawn();
        Pawn pawn2 = new Pawn("black");

        board.addPawn(pawn1);
        assertEquals(1, board.getNumberOfPieces());
        assertEquals("white", board.getPawn(0).getColor());

        board.addPawn(pawn2);
        assertEquals(2, board.getNumberOfPieces());
        assertEquals("black", board.getPawn(1).getColor());
    }*/
}