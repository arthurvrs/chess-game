package chess;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest extends TestCase {

    @Test
    public void testWhitespace() {
        Character character = new Character();
        char newLine = '\n';
        char tab = '\t';
        char backspace = '\b';

        /*assertEquals(true, character.isWhitespace(newLine));
        assertEquals(true, character.isWhitespace(tab));
        assertEquals(true, character.isWhitespace(backspace));*/
    }
}