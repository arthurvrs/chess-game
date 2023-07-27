package chess;

import chess.pieces.Piece;
import junit.framework.TestCase;
import util.StringUtil;

/**
 * Classe de testes para o tabuleiro.
 */
public class BoardTest extends TestCase {

    private final Board board;
    private Board emptyBoard;

    public BoardTest() {
        board = new Board();
        board.initialize();
        emptyBoard = new Board();
    }

    public void testCreate() {
        board.initialize();
        assertEquals(32, board.getNumberOfPieces());
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

    public void testCreateEmptyBoard() {
        String blankRank = StringUtil.appendNewLine("........");
        assertEquals(
                blankRank + blankRank + blankRank + blankRank +
                        blankRank + blankRank + blankRank + blankRank,
                        emptyBoard.print()
        );
    }

    public void testGetNumberOfSpecificsPieces() {
        assertEquals(2, board.getNumberOfSpecificsPieces('N'));
        assertEquals(8, board.getNumberOfSpecificsPieces('p'));
    }

    public void testGetPieceByLocation() {
        assertEquals('R', board.getPieceAtLocation("a8"));
        assertEquals('k', board.getPieceAtLocation("e1"));
        assertEquals('b', board.getPieceAtLocation("f1"));
        assertEquals('P', board.getPieceAtLocation("c7"));
    }

    public void testSetPieceAtLocation() {
        setPieces();
        String blankRank = StringUtil.appendNewLine("........");
        assertEquals(
                StringUtil.appendNewLine(".KR.....") +
                        StringUtil.appendNewLine("P.PB....") +
                        StringUtil.appendNewLine(".P..Q...") +
                        blankRank +
                        StringUtil.appendNewLine(".....nq.") +
                        StringUtil.appendNewLine(".....p.p") +
                        StringUtil.appendNewLine(".....pp.") +
                        StringUtil.appendNewLine("....rk.."),
                emptyBoard.print()
        );
    }

    private void setPieces() {
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.KING_REPRESENTATION, "b8");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.ROOK_REPRESENTATION, "c8");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.PAWN_REPRESENTATION, "a7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.PAWN_REPRESENTATION, "c7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.BISHOP_REPRESENTATION, "d7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.PAWN_REPRESENTATION, "b6");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.QUEEN_REPRESENTATION, "e6");

        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.KNIGHT_REPRESENTATION, "f4");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.QUEEN_REPRESENTATION, "g4");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.PAWN_REPRESENTATION, "f3");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.PAWN_REPRESENTATION, "h3");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.PAWN_REPRESENTATION, "f2");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.PAWN_REPRESENTATION, "g2");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.ROOK_REPRESENTATION, "e1");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.KING_REPRESENTATION, "f1");
    }

    public void testGetPiecesStrength() {
        setPieces();
        assertEquals(20.0, emptyBoard.getPiecesStrength(Piece.Color.black));
        System.out.println(emptyBoard.print());
        assertEquals(19.5, emptyBoard.getPiecesStrength(Piece.Color.white));
        System.out.println(emptyBoard.print());

    }

    public void testGetOrderPiecesStrength() {
        setPieces();
        assertEquals("Q\nR\nB\nP\nP\nP\nK\n", emptyBoard.getOrderStrength(Piece.Color.black));
        assertEquals("q\nr\nn\np\np\np\np\nk\n", emptyBoard.getOrderStrength(Piece.Color.white));

    }

}