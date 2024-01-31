package com.solvd.aviasales.domain.actions;

import com.solvd.aviasales.domain.session.ResultCollector;
import com.solvd.aviasales.util.JsonParser;
import com.solvd.aviasales.util.XmlParserJAXB;
import com.solvd.aviasales.util.ZipArchiver;
import com.solvd.aviasales.util.console_menu.RequestMethods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.solvd.aviasales.util.Printers.*;

public class ConsoleMenuActions {
    protected static final Logger LOGGER = LogManager.getLogger(ConsoleMenuActions.class);

    public static void tearDownActions(ResultCollector result) {
        File generatedJsonFile;
        File generatedXmlFile;
        if (result.getResult().size() > 0) {
            CollectorActions.showResultCollection(result);
            generatedJsonFile = JsonParser.saveToJson(result);
            generatedXmlFile = XmlParserJAXB.saveToXml(result);
            ZipArchiver.archiveFiles(generatedJsonFile, generatedXmlFile);
        } else {
            PRINT2LN.info("[Info]: Result file was not written because there were no actions!");
        }
    }

    public static boolean authenticationActions() {
        String password = RequestMethods.getStringValueFromConsole("admin password");
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property.load(fis);
            if (password.equals(property.getProperty("admin.password"))) {
                PRINTLN.info("[Info]: Password is correct!");
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException("You have been problem with reading from property file!", e);
        }
        LOGGER.error("[Warning]: Password is incorrect!");
        return false;
    }
}
