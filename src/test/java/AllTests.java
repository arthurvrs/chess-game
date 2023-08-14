import chess.BoardTest;
import chess.GameTest;
import chess.pieces.*;
import junit.framework.TestSuite;
import util.*;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PieceTest.class);
        suite.addTestSuite(BoardTest.class);
        suite.addTestSuite(CharacterTest.class);
        suite.addTestSuite(StringUtilTest.class);
        suite.addTestSuite(GameTest.class);

        //Piece tests
        suite.addTestSuite(PawnTest.class);
        suite.addTestSuite(RookTest.class);
        suite.addTestSuite(KnightTest.class);
        suite.addTestSuite(BishopTest.class);
        suite.addTestSuite(QueenTest.class);
        suite.addTestSuite(KingTest.class);

        return suite;
    }
}
