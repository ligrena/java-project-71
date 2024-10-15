package hexlet.code;

import hexlet.code.utils.FormatUtils;
import hexlet.code.utils.KeyDiffBuilder;
import hexlet.code.utils.ParserUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> content1 = ParserUtils.parse(getData(filepath1), FormatUtils.getFileFormat(filepath1));
        Map<String, Object> content2 = ParserUtils.parse(getData(filepath2), FormatUtils.getFileFormat(filepath2));
        TreeMap<String, Map<String, Object>> keyDiff = buildDifference(content1, content2);

        return FormatUtils.format(keyDiff, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String getData(String filepath) throws Exception {
        return Files.readString(Paths.get(filepath).toAbsolutePath()).replaceAll("\r", "");
    }

    public static TreeMap<String, Map<String, Object>> buildDifference(
            Map<String, Object> value1, Map<String, Object> value2) {
        TreeMap<String, Map<String, Object>> keyDiff = new TreeMap<>();

        List<String> keysList = KeyDiffBuilder.getKeysSorted(value1.keySet(), value2.keySet());
        keysList.forEach(x -> keyDiff.put(x, KeyDiffBuilder.keyDiffBuild(value1, value2, x)));

        return keyDiff;
    }
}
