package chess;

import chess.pieces.Piece;
import junit.framework.TestCase;
import util.StringUtil;

/**
 * Classe de testes para o tabuleiro.
 */
public class BoardTest extends TestCase {

    public final Board board;
    public Board emptyBoard;

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
        assertEquals('R', board.getPieceAtLocation("a8").getRepresentation());
        assertEquals('k', board.getPieceAtLocation("e1").getRepresentation());
        assertEquals('b', board.getPieceAtLocation("f1").getRepresentation());
        assertEquals('P', board.getPieceAtLocation("c7").getRepresentation());
    }

    public void testSetPieceAtLocation() {
        setPieces(emptyBoard);
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

    public static void setPieces(Board board) {
        board.setPieceAtLocation(Piece.Color.black, "king", "b8");
        board.setPieceAtLocation(Piece.Color.black, "rook", "c8");
        board.setPieceAtLocation(Piece.Color.black, "pawn", "a7");
        board.setPieceAtLocation(Piece.Color.black, "pawn", "c7");
        board.setPieceAtLocation(Piece.Color.black, "bishop", "d7");
        board.setPieceAtLocation(Piece.Color.black, "pawn", "b6");
        board.setPieceAtLocation(Piece.Color.black, "queen", "e6");

        board.setPieceAtLocation(Piece.Color.white, "knight", "f4");
        board.setPieceAtLocation(Piece.Color.white, "queen", "g4");
        board.setPieceAtLocation(Piece.Color.white, "pawn", "f3");
        board.setPieceAtLocation(Piece.Color.white, "pawn", "h3");
        board.setPieceAtLocation(Piece.Color.white, "pawn", "f2");
        board.setPieceAtLocation(Piece.Color.white, "pawn", "g2");
        board.setPieceAtLocation(Piece.Color.white, "rook", "e1");
        board.setPieceAtLocation(Piece.Color.white, "king", "f1");
    }

    public void testGetPiecesStrength() {
        setPieces(emptyBoard);
        assertEquals(20.0, emptyBoard.getPiecesStrength(Piece.Color.black));
        assertEquals(19.5, emptyBoard.getPiecesStrength(Piece.Color.white));

    }

    public void testGetOrderPiecesStrength() {
        setPieces(emptyBoard);
        assertEquals("Q\nR\nB\nP\nP\nP\nK\n", emptyBoard.getOrderStrength(Piece.Color.black));
        assertEquals("q\nr\nn\np\np\np\np\nk\n", emptyBoard.getOrderStrength(Piece.Color.white));

    }

    public void testGetPieceLocation() {
        setPieces(emptyBoard);
        int[] aux = new int[2];
        aux[0] = 4;
        aux[1] = 5;
        int[] location;
        location = emptyBoard.getPieceLocation('n');
        assertEquals(aux[0], location[0]);
        assertEquals(aux[1], location[1]);
    }
}