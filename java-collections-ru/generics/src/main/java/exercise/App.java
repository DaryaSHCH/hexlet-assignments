package exercise;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> map) {
        List<Map<String, String>> result = new ArrayList<>();
        String bookFromMap = map.toString();
        for (Map<String, String> book : books) {
            for (Map.Entry<String, String> parameterSearching : map.entrySet()) {
                if (book.containsKey(parameterSearching.getKey())
                        && book.containsValue(parameterSearching.getValue())) {
                    if (!result.contains(book)) {
                        result.add(book);
                    }
                } else {
                    result.remove(book);
                    break;
                }
            }
        }
        return result;
    }
}
//END
