package exercises;

import java.util.*;

public class Chapter9 {

    static Map<String, Integer> wordCount = new HashMap<>();

    public static void countingWords(String phrase) {
        for(String word : phrase.split(" ")) {
            word = word.toLowerCase();
            if(word.endsWith("."))
                word = word.substring(0, word.length()-1);

            if(!wordCount.containsKey(word))
                wordCount.put(word, 1);
            else {
                int i = wordCount.get(word) + 1;
                wordCount.put(word, i);
            }
        }
    }

    public static Set<String> wordsCounted() {
        Set<String> words = new HashSet<>();
        for(String word : wordCount.keySet())
            words.add(word + ": " + wordCount.get(word) + " times");

        return words;
    }
}
