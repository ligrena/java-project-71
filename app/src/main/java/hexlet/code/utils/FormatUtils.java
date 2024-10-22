package hexlet.code.utils;

import hexlet.code.Operation;
import hexlet.code.utils.formatters.JsonFormatter;
import hexlet.code.utils.formatters.PlainFormatter;
import hexlet.code.utils.formatters.StylishFormatter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FormatUtils {

    public static String format(Map<String, Operation> keysParams, String format) throws Exception {
        switch (format) {
            case "stylish" -> {
                return StylishFormatter.stylishFormat(keysParams);
            }
            case "plain" -> {
                return PlainFormatter.plainFormat(keysParams);
            }
            case "json" -> {
                return JsonFormatter.jsonFormat(keysParams);
            }
            default -> throw new Exception("Unknown format");
        }
    }

    public static String getFileFormat(String filepath) {
        Path absFilepath = Paths.get(filepath).toAbsolutePath();

        if (absFilepath.toString().endsWith("json")) {
            return "json";
        } else if (absFilepath.toString().endsWith("yaml") || absFilepath.toString().endsWith("yml")) {
            return "yaml";
        } else {
            return "other";
        }
    }
}
