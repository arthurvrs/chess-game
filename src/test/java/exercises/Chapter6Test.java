package exercises;

import junit.framework.TestCase;

public class Chapter6Test extends TestCase {

    public void test1() {
        assertEquals(1, Chapter6.factorial(0));
        assertEquals(1, Chapter6.factorial(1));
        assertEquals(6, Chapter6.factorial(3));
        assertEquals(120, Chapter6.factorial(5));
        assertEquals(362880, Chapter6.factorial(9));
    }

    public void test2() {
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12 ", Chapter6.divisibleByFive(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }
}