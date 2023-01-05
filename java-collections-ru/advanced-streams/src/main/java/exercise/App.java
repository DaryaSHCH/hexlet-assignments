package exercise;

import java.util.stream.Collectors;
//import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String configFile) {
        return   Stream.of(configFile.split("\n"))
                .filter(x -> x.startsWith("environment"))
                .map(x -> x.replaceAll("environment=", ""))
                .flatMap(x -> Stream.of(x.split(",")))
                .map(x -> x.replace("\"", ""))
                .filter(x -> x.startsWith("X_FORWARDED_"))
                .map(x -> x.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
