package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {

    public static void main(String[] args) {
        System.out.println(App.scrabble("rkqodlw", "world")); // true
        System.out.println(App.scrabble("ajv", "java")); // false
        System.out.println(App.scrabble("avjafff", "JaVa")); // true
        System.out.println(App.scrabble("", "hexlet")); // false
    }

    public static boolean scrabble(String characterSet, String word) {
        if ((characterSet.isEmpty()) && (!word.isEmpty())) {
            return false;
        }
        if (word.isEmpty()) {
            return true;
        }
        if (characterSet.trim().equalsIgnoreCase(word.trim())) {
            return true;
        }
        if (characterSet.toLowerCase().contains(word.toLowerCase())) {
            return true;
        }
        String[] arrayFromWord = word.toLowerCase().split("");
        String[] arrayFromCharacterSet = characterSet.toLowerCase().split("");
        List<String> arrayListCharacter = new ArrayList<>(Arrays.asList(arrayFromCharacterSet));
        for (String character: arrayFromWord) {
            if (arrayListCharacter.contains(character)) {
                if (!arrayListCharacter.remove(character)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
