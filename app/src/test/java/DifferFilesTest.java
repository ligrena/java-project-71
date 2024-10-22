import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferFilesTest {

    @Test
    public void testCheckFormatJsonType() throws Exception {
        String jsonFile1 = getPath("file1.json");
        String jsonFile2 = getPath("file2.json");

        String actualResult = Differ.generate(jsonFile1, jsonFile2, "json");
        String expectedResult = Differ.getData(getPath("resultedJsonFile.json"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckFormatJsonWithoutType() throws Exception {
        String jsonFile1 = getPath("file1.json");
        String jsonFile2 = getPath("file2.json");

        String actualResult = Differ.generate(jsonFile1, jsonFile2);
        String expectedResult = Differ.getData(getPath("resultedJsonFilesWithoutType"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckFormatYamlType() throws Exception {
        String yamlFile1 = getPath("file1.yaml");
        String yamlFile2 = getPath("file2.yaml");

        String actualResult = Differ.generate(yamlFile1, yamlFile2, "stylish");
        String expectedResult = Differ.getData(getPath("resultedYamlFiles"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckFormatYamlWithoutType() throws Exception {
        String yamlFile1 = getPath("file1.yaml");
        String yamlFile2 = getPath("file2.yaml");

        String actualResult = Differ.generate(yamlFile1, yamlFile2);
        String expectedResult = Differ.getData(getPath("resultedYamlFiles"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckFormatPlain() throws Exception {
        String jsonFile1 = getPath("fileStylish1.json");
        String jsonFile2 = getPath("fileStylish2.json");

        String actualResult = Differ.generate(jsonFile1, jsonFile2, "plain");
        String expectedResult = Differ.getData(getPath("resultedPlainFiles"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckDefaultFormat() throws Exception {
        String jsonFile1 = getPath("fileStylish1.json");
        String jsonFile2 = getPath("fileStylish2.json");

        String actualResult = Differ.generate(jsonFile1, jsonFile2);
        String expectedResult = Differ.getData(getPath("resultedStylishFiles"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCheckFormatStylishJsonFiles() throws Exception {
        String yamlFile1 = getPath("fileStylish1.yaml");
        String yamlFile2 = getPath("fileStylish2.yaml");

        String expectedResult = Differ.getData(getPath("resultedStylishFiles"));
        String actualFileYaml = Differ.generate(yamlFile1, yamlFile2);

        assertEquals(expectedResult, actualFileYaml);
    }

    @Test
    public void testCheckFormatStylishYamlFiles() throws Exception {
        String jsonFile1 = getPath("fileStylish1.json");
        String jsonFile2 = getPath("fileStylish2.json");

        String expectedResult = Differ.getData(getPath("resultedStylishFiles"));
        String actualFileJson = Differ.generate(jsonFile1, jsonFile2);

        assertEquals(expectedResult, actualFileJson);
    }

    private static String getPath(String fileName) {
        return Paths.get("src", "test", "resources", fileName).toAbsolutePath().normalize().toString();
    }
}
