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

    public void testRethrows() {
        try {
            Chapter8.rethrows();
        } catch(Exception e) {
            assertEquals(SimpleException.class, e.getCause().getClass());
        }
    }

    public void testWithProblems() {
        try {
            doSomething();
            fail("no exception");
        }
        catch (Exception success) {}
    }
    void doSomething() throws Exception {
        throw new Exception("blah");
    }

}