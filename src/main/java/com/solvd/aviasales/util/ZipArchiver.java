package com.solvd.aviasales.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArchiver {
    private static final String resultDirectoryPath = "src/main/resources/results/zip";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private static final String resultFilePath = "src/main/resources/results/zip/result_" + formatter.format(new Date()) + ".zip";

    public static void archiveJson(File generatedJsonFile) {
        File directory = new File(resultDirectoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try (FileOutputStream zipFile = new FileOutputStream(resultFilePath);
             ZipOutputStream zip = new ZipOutputStream(zipFile)) {
            zip.putNextEntry(new ZipEntry(generatedJsonFile.getName()));
            File file = new File(generatedJsonFile.getPath());
            Files.copy(file.toPath(), zip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
