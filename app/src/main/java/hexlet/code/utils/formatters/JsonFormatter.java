package hexlet.code.utils.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class JsonFormatter {

    public static String jsonFormat(
            TreeMap<String, Map<String, Object>> keysParams) throws RuntimeException, IOException {
        return new ObjectMapper().writeValueAsString(keysParams);
    }
}
