package exercise;

import java.util.Map;
import java.util.Map.Entry;

import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage dataBase) {
        Map<String, String> result = dataBase.toMap().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        for (Map.Entry<String, String> keys : dataBase.toMap().entrySet()) {
            dataBase.unset(keys.getKey());
        }

        for (Map.Entry<String, String> entry : result.entrySet()) {
            dataBase.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
