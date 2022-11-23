package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        String[] lettersArray = letters.split("");
        List<String> listLetters = new ArrayList<>();
        for (var i = 0; i < lettersArray.length; i++) {
            listLetters.add(lettersArray[i]);
        }
        for (var j = 0; j < word.length(); j++) {
            var letterFromWord = word.substring(j, j + 1);
            if (listLetters.contains(letterFromWord.toLowerCase())) {
                listLetters.remove(letterFromWord);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
