package exercise;

//import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> actual = App.take(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), 2);

        // END
    }
}
