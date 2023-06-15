package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> houses, int n) {
        return houses.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(((Integer) n).longValue())
                .map(Home::toString)
                .collect(Collectors.toList());
    }
}

// END
