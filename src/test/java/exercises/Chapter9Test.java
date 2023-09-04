package exercises;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class Chapter9Test extends TestCase {

    public void testCountingWords() {
        String phrase = "Create a String literal using the first two sentences of this exercise. " +
                "You will create a WordCount class to parse through the text and count the number " +
                "of instances of each word.";

        Chapter9.countingWords(phrase);
        assertTrue(Chapter9.wordCount.containsKey("create"));
        assertTrue(Chapter9.wordCount.containsKey("through"));
        assertTrue(Chapter9.wordCount.containsKey("instances"));
        assertEquals((Integer) 3, Chapter9.wordCount.get("the"));
        assertEquals((Integer) 2, Chapter9.wordCount.get("a"));
        assertEquals((Integer) 1, Chapter9.wordCount.get("exercise"));

        Set<String> words = Chapter9.wordsCounted();

        for(String word : words)
            System.out.println(word);
    }

    public void testName() {
        Name name = new Name("Arthur");
        Name otherName = new Name("Arthur");
        Name anotherName = new Name("Artur");
        assertEquals(otherName, name);
        assertNotSame(anotherName, name);

        Set<Name> names = new HashSet<>();
        Name foo = new Name("Foo");
        names.add(foo);
        assertTrue(names.contains(new Name("Foo")));
        assertTrue(names.contains(foo));
    }
}