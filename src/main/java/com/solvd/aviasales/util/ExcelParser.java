package com.solvd.aviasales.util;

import com.solvd.aviasales.domain.session.FinalRoute;
import com.solvd.aviasales.domain.structure.Route;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.solvd.aviasales.util.Printers.*;

public class ExcelParser {
    private static final String resultDirectoryPath = "src/main/resources/results/excel";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private static final String resultFilePath = "src/main/resources/results/excel/result_" + formatter.format(new Date()) + ".xlsx";

    public static void saveToExcel(FinalRoute finalRoute) {
        File directory = new File(resultDirectoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Chosen route collection");
        sheet.setColumnWidth(0, 7000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 4000);
        sheet.setColumnWidth(3, 4000);

        createItem(workbook, sheet, "Route", finalRoute.getRouteName(), 0);
        createItem(workbook, sheet, "Seat class", finalRoute.getSeatClass(), 1);
        createItem(workbook, sheet, "Total price", "$" + finalRoute.getTotalPrice(), 2);
        createItem(workbook, sheet, "Total distance", finalRoute.getTotalDistance() + "km", 3);
        if (finalRoute.getTransfers() == 1) {
            createItem(workbook, sheet, "Transfers, no more than", finalRoute.getTransfers() + " item", 4);
        } else {
            createItem(workbook, sheet, "Transfers, no more than", finalRoute.getTransfers() + " items", 4);
        }
        createItem(workbook, sheet, "Route chain", "", 5);
        int index = 6;
        for (Route route : finalRoute.getRouteCollection()) {
            createWideItem(workbook, sheet, index - 5 + " route", route, index);
            index++;
        }

        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(resultFilePath);
            workbook.write(outputStream);
            workbook.close();
            PRINT2LN.info(String.format("[Info]: Result file '%s' was written!", resultFilePath.substring(33)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createItem(Workbook workbook, Sheet sheet, String name, String value, int rowNumber) {
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        headerStyle.setFont(font);
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Row row = sheet.createRow(rowNumber);
        Cell cell = row.createCell(0);
        cell.setCellValue(name);
        cell.setCellStyle(headerStyle);
        cell = row.createCell(1);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    private static void createWideItem(Workbook workbook, Sheet sheet, String name, Route route, int rowNumber) {
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        headerStyle.setFont(font);
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Row row = sheet.createRow(rowNumber);
        Cell cell = row.createCell(0);
        cell.setCellValue(name);
        cell.setCellStyle(headerStyle);
        cell = row.createCell(1);
        cell.setCellValue(route.getCountryFrom() + "-" + route.getCountryTo());
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("$" + route.getPrice());
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue(route.getDistance() + "km");
        cell.setCellStyle(style);
    }
}
