package exercises;

public class Chapter8 {

    public static void blowsUp() {
        throw new SimpleException();
    }

    public static void rethrows() throws RuntimeException {
        try {
            blowsUp();
        } catch(RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
