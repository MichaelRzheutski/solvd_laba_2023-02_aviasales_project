package com.solvd.aviasales.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArchiver {
    private static final String resultDirectoryPath = "src/main/resources/results/zip";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private static final String resultFilePath = "src/main/resources/results/zip/result_" + formatter.format(new Date()) + ".zip";

    public static void archiveFiles(File generatedJsonFile, File generatedXmlFile) {
        File directory = new File(resultDirectoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try (FileOutputStream zipFile = new FileOutputStream(resultFilePath);
             ZipOutputStream zip = new ZipOutputStream(zipFile)) {
            File jsonFile = new File(generatedJsonFile.getPath());
            File xmlFile = new File(generatedXmlFile.getPath());
            List<File> files = new ArrayList<>();
            files.add(jsonFile);
            files.add(xmlFile);
            byte[] buffer = new byte[1024];

            for (int i = 0; i < files.size(); i++) {
                FileInputStream fis = new FileInputStream(files.get(i));
                zip.putNextEntry(new ZipEntry(files.get(i).getName()));
                int length;

                while ((length = fis.read(buffer)) > 0) {
                    zip.write(buffer, 0, length);
                }
                zip.closeEntry();
                fis.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
