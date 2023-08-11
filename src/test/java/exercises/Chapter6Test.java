package exercises;

import junit.framework.TestCase;

import java.util.Vector;

public class Chapter6Test extends TestCase {

    public void test1() {
        assertEquals(1, Chapter6.factorial(0));
        assertEquals(1, Chapter6.factorial(1));
        assertEquals(6, Chapter6.factorial(3));
        assertEquals(120, Chapter6.factorial(5));
        assertEquals(362880, Chapter6.factorial(9));
    }

    public void test2() {
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12", Chapter6.divisibleByFive(Chapter6.numbers));
    }

    public void test3a() {
        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");
        vector.add("5*");
        vector.add("6");
        vector.add("7");
        vector.add("8");
        vector.add("9");
        vector.add("10*");
        vector.add("11");
        vector.add("12");

        assertEquals(vector, Chapter6.splitString());

    }

    public void test3b() {
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12", Chapter6.iterate());
    }
}