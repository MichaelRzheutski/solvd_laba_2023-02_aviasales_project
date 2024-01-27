package com.solvd.aviasales.util;

import com.solvd.aviasales.domain.session.ResultCollector;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.solvd.aviasales.util.Printers.PRINT2LN;

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
            PRINT2LN.info(String.format("[Info]: Result file '%s' was written!", file.getName()));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return file;
    }
}
