import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferFilesTest {

    @Test
    public void checkFormatJson() throws Exception {
        String jsonFile1 = Paths.get("").toAbsolutePath() + "/src/test/resources/file1.json";
        String jsonFile2 = Paths.get("").toAbsolutePath() + "/src/test/resources/file2.json";

        String actual = Differ.generate(jsonFile1, jsonFile2, "json");
        String expectedResult = Differ.getData("src/test/resources/resultedJsonFile.json");

        assertEquals(expectedResult, actual);
    }

    @Test
    public void checkFormatYaml() throws Exception {
        String yamlFile1 = Paths.get("").toAbsolutePath() + "/src/test/resources/file1.yaml";
        String yamlFile2 = Paths.get("").toAbsolutePath() + "/src/test/resources/file2.yaml";

        String actual = Differ.generate(yamlFile1, yamlFile2);
        String expectedResult = Differ.getData("src/test/resources/resultedYamlFiles");

        assertEquals(expectedResult, actual);
    }

    @Test
    public void checkFormatStylish() throws Exception {
        String jsonFile1 = Paths.get("").toAbsolutePath() + "/src/test/resources/fileStylish1.json";
        String jsonFile2 = Paths.get("").toAbsolutePath() + "/src/test/resources/fileStylish2.json";

        String yamlFile1 = Paths.get("").toAbsolutePath() + "/src/test/resources/fileStylish1.yaml";
        String yamlFile2 = Paths.get("").toAbsolutePath() + "/src/test/resources/fileStylish2.yaml";

        String actualFileJson = Differ.generate(jsonFile1, jsonFile2);
        String expectedResult = Differ.getData("src/test/resources/resultedStylishFiles");

        assertEquals(expectedResult, actualFileJson);

        String actualFileYaml = Differ.generate(yamlFile1, yamlFile2);

        assertEquals(expectedResult, actualFileYaml);
    }

    @Test
    public void checkFormatPlain() throws Exception {
        String jsonFile1 = Paths.get("").toAbsolutePath() + "/src/test/resources/fileStylish1.json";
        String jsonFile2 = Paths.get("").toAbsolutePath() + "/src/test/resources/fileStylish2.json";

        String actual = Differ.generate(jsonFile1, jsonFile2, "plain");
        String expected = Differ
                .getData("src/test/resources/resultedPlainFiles");

        assertEquals(expected, actual);

    }
}
