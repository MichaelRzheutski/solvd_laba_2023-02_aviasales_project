package com.solvd.aviasales.util;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.solvd.aviasales.domain.session.ResultCollector;

import java.io.File;
import java.io.IOException;

import static com.solvd.aviasales.util.Printers.*;

public class JsonParser {
    private static final String resultDirectoryPath = "src/main/resources/json";
    private static final String resultFilePath = "src/main/resources/json/result.json";

    public static void saveToJson(ResultCollector result) {
        File directory = new File(resultDirectoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        File file = new File(resultFilePath);
        try {
            writer.writeValue(file, result);
            PRINT2LN.info(String.format("[Info]: Result file '%s' was written!", file.getName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
