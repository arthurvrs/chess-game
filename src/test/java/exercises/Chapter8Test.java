package exercises;

import junit.framework.TestCase;

public class Chapter8Test extends TestCase {

    public void testBlowsUp() {
        try {
            Chapter8.blowsUp();
            fail("Somebody should catch this!");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException");
        }
    }

    public void testRethrows() throws RuntimeException {
        Chapter8.rethrows();
    }

}