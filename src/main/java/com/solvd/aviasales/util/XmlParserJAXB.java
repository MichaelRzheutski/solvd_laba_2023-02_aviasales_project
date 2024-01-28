package com.solvd.aviasales.util;

import com.solvd.aviasales.domain.session.ResultCollector;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.solvd.aviasales.util.Printers.*;

public class XmlParserJAXB {
    private static final String resultDirectoryPath = "src/main/resources/results/xml";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private static final String resultFilePath = "src/main/resources/results/xml/result_" + formatter.format(new Date()) + ".xml";

    public static File saveToXml(ResultCollector result) {
        File directory = new File(resultDirectoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File(resultFilePath);

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(ResultCollector.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(result, file);
            PRINTLN.info(String.format("[Info]: Result file '%s' was written!", file.getName()));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return file;
    }
}
