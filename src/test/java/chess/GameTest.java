package chess;

import chess.pieces.Piece;
import junit.framework.TestCase;
import util.StringUtil;

public class GameTest extends TestCase {

    Game game;

    public GameTest() {
        game = Game.startGame();
    }

    public void testGame() {
        assertEquals(Game.class, game.getClass());
        assertEquals(Board.class, game.getBoard().getClass());
    }

    public void testMove() {
        BoardTest.setPieces(game.getBoard());
        game.move("b8", Piece.Movement.left, 1);
        game.move("e6", Piece.Movement.right, 3);
        game.move("h6", Piece.Movement.down, 2);
        game.move("h4", Piece.Movement.downLeft, 1);
        game.move("g3", Piece.Movement.downRight, 1);
        String blankRank = StringUtil.appendNewLine("........");
        assertEquals(
                StringUtil.appendNewLine("K.R.....") +
                        StringUtil.appendNewLine("P.PB....") +
                        StringUtil.appendNewLine(".P......") +
                        blankRank +
                        StringUtil.appendNewLine(".....nq.") +
                        StringUtil.appendNewLine(".....p.p") +
                        StringUtil.appendNewLine(".....ppQ") +
                        StringUtil.appendNewLine("....rk.."),
                game.getBoard().print()
        );
        game.moveKing(Piece.Color.black, "right");
    }
}