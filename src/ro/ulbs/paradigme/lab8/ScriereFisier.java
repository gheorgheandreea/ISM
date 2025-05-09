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
        // Crearea unui nou workbook XLSX
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        // Datele pentru tabel
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] {"First Name", "Last Name", "D", "E", "F", "MAX", "AVERAGE"});
        data.put("2", new Object[] {"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[] {"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[] {"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[] {"Brian", "Schultz", 7, 6, 8, 9});

        // Creare stil pentru header - fundal verde și font bold
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Creare stil pentru coloanele G și H - fundal galben
        XSSFCellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Scrie datele în fișier
        int rownum = 0;
        for (String key : data.keySet()) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);

                // Aplică stilul de header pentru primul rând
                if (rownum == 1) {
                    cell.setCellStyle(headerStyle);
                }

                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }

            // Adaugă formulele pentru coloanele G și H, începând de la al doilea rând
            if (rownum > 1) {
                // Adaugă formula MAX pentru coloana G
                Cell cellG = row.createCell(6);
                cellG.setCellFormula("MAX(D" + rownum + ":F" + rownum + ")");
                cellG.setCellStyle(yellowStyle);

                // Adaugă formula AVERAGE pentru coloana H
                Cell cellH = row.createCell(7);
                cellH.setCellFormula("AVERAGE(D" + rownum + ":F" + rownum + ")");
                cellH.setCellStyle(yellowStyle);
            } else {
                // Aplică stilul header pentru celulele G și H din primul rând
                Cell cellG = row.createCell(6);
                cellG.setCellValue("MAX");
                cellG.setCellStyle(headerStyle);

                Cell cellH = row.createCell(7);
                cellH.setCellValue("AVERAGE");
                cellH.setCellStyle(headerStyle);
            }
        }

        // Ajustează lățimea coloanelor automat
        for (int i = 0; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }

        // Salvează workbook-ul în fișier
        try {
            FileOutputStream out = new FileOutputStream("output8.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("Fișierul Excel a fost creat cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
