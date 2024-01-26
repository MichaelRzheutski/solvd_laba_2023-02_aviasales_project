package com.solvd.aviasales.util.console_menu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.solvd.aviasales.domain.session.ResultCollector;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonParser {
<<<<<<< Updated upstream

    private static final String resultPath = "src/main/resources/json/result.json";
=======
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private static final String resultPath = "src/main/resources/json/result_" + formatter.format(new Date()) + ".json";
>>>>>>> Stashed changes

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
