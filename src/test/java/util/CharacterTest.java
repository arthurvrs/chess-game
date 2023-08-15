package util;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {

    /*public void testWhitespace() {
        Character character = new Character();
        char newLine = '\n';
        char tab = '\t';
        char backspace = '\b';

        *//*assertEquals(true, character.isWhitespace(newLine));
        assertEquals(true, character.isWhitespace(tab));
        assertEquals(true, character.isWhitespace(backspace));*//*
    }*/

    public void testGetLocation() {
        int [] aux =  Character.getLocation("e1");
        assertEquals(7, aux[0]);
        assertEquals(4, aux[1]);
        System.out.println(aux[0]);
        System.out.println(aux[1]);

        String location = Character.getLocation(aux);
        assertEquals("e1", location);
    }
}