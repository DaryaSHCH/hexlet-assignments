package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// END


class FileKVTest {

    private static final Path FILE_PATH = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(FILE_PATH, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void fileKVTest() {
        Map<String, String> newMap = new HashMap<>();
        newMap.put("k1", "v1");
        KeyValueStorage storage = new FileKV(FILE_PATH.toString(), newMap);
        assertThat(storage.get("k2", "default")).isEqualTo("default");
        assertThat(storage.get("k1", "default")).isEqualTo("v1");

        storage.set("k2", "v2");
        assertThat(storage.get("k2", "default")).isEqualTo("v2");

        storage.unset("k1");
        assertThat(storage.get("k1", "def")).isEqualTo("def");

        assertThat(storage.toMap()).isEqualTo(Map.of("k2", "v2"));
    }
    // END
}
