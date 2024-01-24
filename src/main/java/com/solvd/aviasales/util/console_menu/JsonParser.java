package com.solvd.aviasales.util.console_menu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.solvd.aviasales.domain.session.ResultCollector;

import java.io.File;
import java.io.IOException;

public class JsonParser {

    private static final String resultPath = "src/main/resources/json/result.json";

    public static void saveToJson(ResultCollector result) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        File file = new File(resultPath);

        try {
            writer.writeValue(file, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
