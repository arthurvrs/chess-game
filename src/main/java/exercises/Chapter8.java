package exercises;

public class Chapter8 {

    public static void blowsUp() throws RuntimeException {
        throw new RuntimeException();
    }

    public static void rethrows() throws RuntimeException {
        try {
            blowsUp();
        } catch(RuntimeException e) {
            e.getCause();
        }
    }
}
