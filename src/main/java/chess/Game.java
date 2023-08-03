package chess;

public class Game {

    Board board;

    private Game() {
        board = new Board();
    }

    public static Game startGame() {
        return new Game();
    }


}
