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
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.Type.KING, "b8");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.Type.ROOK, "c8");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.Type.PAWN, "a7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.Type.PAWN, "c7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.Type.BISHOP, "d7");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.Type.PAWN, "b6");
        emptyBoard.setPieceAtLocation(Piece.Color.black, Piece.Type.QUEEN, "e6");

        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.KNIGHT, "f4");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.QUEEN, "g4");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.PAWN, "f3");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.PAWN, "h3");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.PAWN, "f2");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.PAWN, "g2");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.ROOK, "e1");
        emptyBoard.setPieceAtLocation(Piece.Color.white, Piece.Type.KING, "f1");
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