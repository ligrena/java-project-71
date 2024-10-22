package hexlet.code;

import hexlet.code.utils.FormatUtils;
import hexlet.code.utils.KeyDiffBuilder;
import hexlet.code.utils.ParserUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> content1 = ParserUtils.parse(getData(filepath1), FormatUtils.getFileFormat(filepath1));
        Map<String, Object> content2 = ParserUtils.parse(getData(filepath2), FormatUtils.getFileFormat(filepath2));

        Map<String, Operation> keyDiff = KeyDiffBuilder.buildDifference(content1, content2);

        return FormatUtils.format(keyDiff, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String getData(String filepath) throws Exception {
        return Files.readString(Paths.get(filepath).toAbsolutePath()).replaceAll("\r", "");
    }
}
