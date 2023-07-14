import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @Test
    public void testCreate() {
        final String firstPawnColor = "white";
        Pawn pawn = new Pawn(firstPawnColor);
        assertEquals(firstPawnColor, pawn.getColor());

        final String secondPawnColor = "black";
        Pawn secondPawn = new Pawn(secondPawnColor);
        assertEquals(secondPawnColor, secondPawn.getColor());

    }
}