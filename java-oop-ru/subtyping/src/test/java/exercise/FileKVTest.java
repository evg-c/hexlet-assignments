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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testGet() {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("key", "value");
        KeyValueStorage storage = new FileKV("", myMap);
        String expected = "value";
        assertThat(storage.get("key", "default")).isEqualTo(expected);
    }

    public void testMapTo() {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("key", "value");
        KeyValueStorage storage = new FileKV("", myMap);
        assertThat(storage.toMap()).isEqualTo(myMap);
    }

    public void testSave() {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("key", "value");
        String pathToFile = "src/test/resources/file";
        FileKV storage = new FileKV(pathToFile, myMap);
        storage.save(pathToFile, myMap);
        assertThat(storage.restore("src/test/resources/file")).isEqualTo(myMap);
    }
    // END
}
