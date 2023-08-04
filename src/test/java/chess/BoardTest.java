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
        System.out.println(board.print());
    }

    public void testCreateEmptyBoard() {
        String blankRank = StringUtil.appendNewLine("........");
        assertEquals(
                blankRank + blankRank + blankRank + blankRank +
                        blankRank + blankRank + blankRank + blankRank,
                        emptyBoard.print()
        );
        System.out.println(emptyBoard.print());
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
        emptyBoard.setPieceAtLocation(Piece.Color.black, "king", "b8");
        emptyBoard.setPieceAtLocation(Piece.Color.black, "rook", "c8");
        emptyBoard.setPieceAtLocation(Piece.Color.black, "pawn", "a7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, "pawn", "c7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, "bishop", "d7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, "pawn", "b6");
        emptyBoard.setPieceAtLocation(Piece.Color.black, "queen", "e6");

        emptyBoard.setPieceAtLocation(Piece.Color.white, "knight", "f4");
        emptyBoard.setPieceAtLocation(Piece.Color.white, "queen", "g4");
        emptyBoard.setPieceAtLocation(Piece.Color.white, "pawn", "f3");
        emptyBoard.setPieceAtLocation(Piece.Color.white, "pawn", "h3");
        emptyBoard.setPieceAtLocation(Piece.Color.white, "pawn", "f2");
        emptyBoard.setPieceAtLocation(Piece.Color.white, "pawn", "g2");
        emptyBoard.setPieceAtLocation(Piece.Color.white, "rook", "e1");
        emptyBoard.setPieceAtLocation(Piece.Color.white, "king", "f1");
    }

    public void testGetPiecesStrength() {
        setPieces();
        assertEquals(20.0, emptyBoard.getPiecesStrength(Piece.Color.black));
        assertEquals(19.5, emptyBoard.getPiecesStrength(Piece.Color.white));

    }

    public void testGetOrderPiecesStrength() {
        setPieces();
        assertEquals("Q\nR\nB\nP\nP\nP\nK\n", emptyBoard.getOrderStrength(Piece.Color.black));
        assertEquals("q\nr\nn\np\np\np\np\nk\n", emptyBoard.getOrderStrength(Piece.Color.white));

    }

    public void testMove() {
        setPieces();
        emptyBoard.moveKing(Piece.Color.black, "left");
        String blankRank = StringUtil.appendNewLine("........");
        assertEquals(
                StringUtil.appendNewLine("K.R.....") +
                        StringUtil.appendNewLine("P.PB....") +
                        StringUtil.appendNewLine(".P..Q...") +
                        blankRank +
                        StringUtil.appendNewLine(".....nq.") +
                        StringUtil.appendNewLine(".....p.p") +
                        StringUtil.appendNewLine(".....pp.") +
                        StringUtil.appendNewLine("....rk.."),
                emptyBoard.print()
        );
        emptyBoard.moveKing(Piece.Color.black, "right");
    }

    public void testGetPieceLocation() {
        setPieces();
        int[] aux = new int[2];
        aux[0] = 4;
        aux[1] = 5;
        int[] location;
        location = emptyBoard.getPieceLocation('n');
        assertEquals(aux[0], location[0]);
        assertEquals(aux[1], location[1]);
    }
}