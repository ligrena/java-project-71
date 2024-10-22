package hexlet.code.utils.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Operation;

import java.io.IOException;
import java.util.Map;

public class JsonFormatter {

    public static String jsonFormat(Map<String, Operation> keysParams) throws RuntimeException, IOException {
        return new ObjectMapper().writeValueAsString(keysParams);
    }
}
