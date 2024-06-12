package org.odev8;
import java.util.*;
public class KelimeDizisi {
    public static void main(String[] args) {
        // 1. Create a list of words
        List<String> wordArray = Arrays.asList("kalem", "elalem", "kelam", "kelime");

        // 2. Find words with repeated letters
        List<String> repeatedLetterWords = new ArrayList<>();

        for (String word : wordArray) {
            if (hasRepeatedLetters(word)) {
                repeatedLetterWords.add(word);
            }

            // 3. Stop searching when two words are found
            if (repeatedLetterWords.size() == 2) {
                break;
            }
        }

        // If two words with repeated letters are found
        if (repeatedLetterWords.size() == 2) {
            // 4. Combine the letters of the two words
            String word1 = repeatedLetterWords.get(0);
            String word2 = repeatedLetterWords.get(1);
            String combinedLetters = word1 + word2;

            // Create a random text from the combined letters
            String randomText = createRandomText(combinedLetters);
            System.out.println("Two words with repeated letters: " + word1 + ", " + word2);
            System.out.println("Generated text: " + randomText);
        } else {
            System.out.println("Not enough words with repeated letters found.");
        }
    }

    // Function to check if a word has repeated letters
    public static boolean hasRepeatedLetters(String word) {
        Set<Character> letters = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (letters.contains(c)) {
                return true; // Repeated letter found
            }
            letters.add(c);
        }
        return false; // No repeated letter found
    }

    // Function to create a random text from the letters
    public static String createRandomText(String letters) {
        List<Character> letterList = new ArrayList<>();
        for (char c : letters.toCharArray()) {
            letterList.add(c);
        }
        Collections.shuffle(letterList); // Shuffle the letters

        StringBuilder randomText = new StringBuilder();
        for (char c : letterList) {
            randomText.append(c);
        }
        return randomText.toString();
    }
}