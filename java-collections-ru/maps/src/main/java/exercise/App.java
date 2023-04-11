package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void main(String[] args) {
        String sentence = "java is the best programming language java";
        Map wordsCount = App.getWordCount(sentence);
        System.out.println(wordsCount);
        System.out.println(App.toString(wordsCount));
    }

    public static Map getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        if (sentence.trim().isEmpty()) {
            return words;
        }
        String[] arrayFromSentence = sentence.split(" ");
        for (String word: arrayFromSentence) {
            if (words.containsKey(word)) {
                int currentValue = words.get(word);
                words.replace(word, currentValue + 1);
            } else {
                words.put(word, 1);
            }
        }
        return words;
    }

    public static String toString(Map<String, Integer> mapWords) {
        String resultStringMap;
        StringBuffer resultString = new StringBuffer();
        resultString.append("{");
        for (Map.Entry<String, Integer> words: mapWords.entrySet()) {
            resultString.append("\n" + "  " + words.getKey() + ": " + words.getValue());
        }
        if (!mapWords.isEmpty()) {
            resultString.append("\n");
        }
        resultString.append("}");
        resultStringMap = resultString.toString();
        return resultStringMap;
    }
}
//END
