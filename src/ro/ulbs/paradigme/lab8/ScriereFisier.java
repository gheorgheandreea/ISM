package ro.ulbs.paradigme.lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class ScriereFisier {
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("2", new Object[] {"Amit", "Shukla", 9,8,7,5});
        data.put("3", new Object[] {"Lokesh", "Gupta", 8,9,6,7});
        data.put("4", new Object[] {"John", "Adwards", 8,8,7,6 });
        data.put("5", new Object[] {"Brian", "Schultz", 7,6,8,9});
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setItalic(false);
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        headerFont= workbook.createFont();
        headerFont.setColor(IndexedColors.AUTOMATIC.getIndex());
        headerFont.setBold(false);
        headerFont.setItalic(true);
        XSSFCellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        yellowStyle.setFont(headerFont);
        int rownum = 0;
        Row row = sheet.createRow(rownum++);
        String expression="";
            int cellnum = 0;
            String[] headers={"Name","Surname","Grade 1","Grade 2","Grade 2","Grade 4","Max","Average"};
        for (String header : headers) {
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue(header);
            cell.setCellStyle(headerStyle);
        }
        int rowNum = 1;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row1 = sheet.createRow(rowNum);
            Object[] values = entry.getValue();
            int colNum = 0;
            for (Object val : values) {
                Cell cell = row1.createCell(colNum++);
                if (val instanceof String) {
                    cell.setCellValue((String) val);
                } else if (val instanceof Integer) {
                    cell.setCellValue((Integer) val);
                }
            }
            String rowExcel = String.valueOf(rowNum + 1); // rândul în Excel (începe de la 1)
            String maxFormula = "MAX(C" + rowExcel + ":F" + rowExcel + ")";
            Cell maxCell = row1.createCell(6);
            maxCell.setCellFormula(maxFormula);
            maxCell.setCellStyle(yellowStyle);

            String avgFormula = "AVERAGE(C" + rowExcel + ":F" + rowExcel + ")";
            Cell avgCell = row1.createCell(7);
            avgCell.setCellFormula(avgFormula);
            avgCell.setCellStyle(yellowStyle);

            rowNum++;
    }
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream out = new FileOutputStream("output8.xlsx")) {
            workbook.write(out);
            workbook.close();
            System.out.println("Fișierul output8.xlsx a fost generat cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
}}
