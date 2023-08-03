package chess;

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
        return suite;
    }
}
