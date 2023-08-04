package chess.pieces;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Classe de testes para os Peões.
 */
public class PieceTest extends TestCase {

    ArrayList<Piece> pieces = new ArrayList<>();

    /**
     * Método para testar a criação de peões.
     */
    public void testCreate() {
        pieces.add(Blank.createPiece());
        assertEquals('.', pieces.get(0).getRepresentation());
        assertEquals(Piece.Color.blank, pieces.get(0).getColor());
        assertEquals(Blank.class, pieces.get(0).getClass());

        pieces.add(Pawn.createPiece(Piece.Color.black));
        assertEquals('P', pieces.get(1).getRepresentation());
        assertEquals(Piece.Color.black, pieces.get(1).getColor());
        assertEquals(Pawn.class, pieces.get(1).getClass());

        pieces.add(Pawn.createPiece(Piece.Color.white));
        assertEquals('p', pieces.get(2).getRepresentation());
        assertEquals(Piece.Color.white, pieces.get(2).getColor());
        assertEquals(Pawn.class, pieces.get(2).getClass());

        pieces.add(Rook.createPiece(Piece.Color.white));
        assertEquals('r', pieces.get(3).getRepresentation());
        assertEquals(Piece.Color.white, pieces.get(3).getColor());
        assertEquals(Rook.class, pieces.get(3).getClass());

        pieces.add(Knight.createPiece(Piece.Color.black));
        assertEquals('N', pieces.get(4).getRepresentation());
        assertEquals(Piece.Color.black, pieces.get(4).getColor());
        assertEquals(Knight.class, pieces.get(4).getClass());

        pieces.add(Bishop.createPiece(Piece.Color.white));
        assertEquals('b', pieces.get(5).getRepresentation());
        assertEquals(Piece.Color.white, pieces.get(5).getColor());
        assertEquals(Bishop.class, pieces.get(5).getClass());

        pieces.add(Queen.createPiece(Piece.Color.black));
        assertEquals('Q', pieces.get(6).getRepresentation());
        assertEquals(Piece.Color.black, pieces.get(6).getColor());
        assertEquals(Queen.class, pieces.get(6).getClass());

        pieces.add(King.createPiece(Piece.Color.white));
        assertEquals('k', pieces.get(7).getRepresentation());
        assertEquals(Piece.Color.white, pieces.get(7).getColor());
        assertEquals(King.class, pieces.get(7).getClass());

    }
}