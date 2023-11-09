package com.ec.booker.Utils.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.thucydides.core.steps.StepInterceptor;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static com.ec.booker.Utils.file.ExceptionMessages.ERROR_READING_JSON_FILE;

public class JsonFiles<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);
    private static final String EXTENSION = ".json";

    public static Object readJsonFile(String directory, String fileName) {
        Object obj = null;
        try {
            JSONParser parser = new JSONParser();
            obj = parser.parse(new FileReader(directory + fileName + EXTENSION));
        } catch (Exception e) {
            LOGGER.error(ERROR_READING_JSON_FILE.getMessage() + fileName + ": ", e);
        }
        return obj;
    }

    public static <T> T getObjectJava(String directory, String fileName, Class<T> clase) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(directory + fileName + EXTENSION), clase);
        } catch (IOException e) {
            LOGGER.error(ERROR_READING_JSON_FILE.getMessage() + fileName + ": ", e);
            return null;
        }
    }
}
