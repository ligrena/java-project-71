import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferFilesTest {

    @Test
    public void testFormatJson() throws Exception {
        String jsonFile1 = Paths.get("").toAbsolutePath() + "/src/test/resources/file1.json";
        String jsonFile2 = Paths.get("").toAbsolutePath() + "/src/test/resources/file2.json";

        String actual = Differ.generate(jsonFile1, jsonFile2, "json");

        String expected = Differ.getData("src/test/resources/resultedJsonFile.json");

        assertEquals(expected, actual);
    }
}
