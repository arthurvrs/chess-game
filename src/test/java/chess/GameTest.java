package chess;

import junit.framework.TestCase;

public class GameTest extends TestCase {

    Game game;

    public GameTest() {
        game = Game.startGame();
    }

    public void testGame() {
        assertEquals(Game.class, game.getClass());
    }


}