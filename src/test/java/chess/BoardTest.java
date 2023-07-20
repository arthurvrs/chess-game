package chess;

import chess.pieces.Piece;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import util.StringUtil;

/**
 * Classe de testes para o tabuleiro.
 */
public class BoardTest extends TestCase {

    private Board board;

    public BoardTest() {
        Piece.resetCOUNT();
        board = new Board();
    }

    @Test
    public void testCreate() {
        board.initialize();
        assertEquals(32, board.getNumberOfPieces());
        System.out.println(board.print());
        String blankRank = StringUtil.appendNewLine("........");
        assertEquals(
                StringUtil.appendNewLine("RNBQKBNR") +
                        StringUtil.appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        StringUtil.appendNewLine("pppppppp") +
                        StringUtil.appendNewLine("rnbqkbnr"),
                        board.print()
        );
    }

    /**
     * Método que adiciona peões ao tabuleiro.
     * Adiciona um peão branco e um preto.
     */
    /*@Test
    public void testAddPawn() {
        Piece pawn1 = new Piece();
        Piece pawn2 = new Piece("black");

        board.addPawn(pawn1);
        assertEquals(1, board.getNumberOfPieces());
        assertEquals("white", board.getPawn(0).getColor());

        board.addPawn(pawn2);
        assertEquals(2, board.getNumberOfPieces());
        assertEquals("black", board.getPawn(1).getColor());
    }*/
}