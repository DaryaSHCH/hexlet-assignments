package exercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.trim().equals("")) {
            return Collections.emptyMap();
        } else {
            Map<String, Integer> map = new HashMap<>();
            String[] words = sentence.split(" ");

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (!map.containsKey(word)) {
                    map.put(word, 0);
                }
                map.put(word, map.get(word) + 1);
            }

            return map;
        }
    }
    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }

        StringBuilder mapAsString = new StringBuilder("{\n");
        for (String key : map.keySet()) {
            mapAsString.append("  " + key + ": " + map.get(key) + "\n");
        }

        mapAsString.append("}");

        return mapAsString.toString();
    }
}
//END
