package ro.ulbs.proiectaresoftware.lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Main {
    public static void copiazafisier2() throws IOException {
        FileInputStream file = new FileInputStream(new File("lab8ex1.xlsx"));
        XSSFWorkbook workbook3 = new XSSFWorkbook(file);
        XSSFSheet sheet3 = workbook3.getSheetAt(0);

        Iterator<Row> rowIterator = sheet3.iterator();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();


            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();


                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }

            if (row.getRowNum() == 0) {
                Cell titlu = row.createCell(6);
                titlu.setCellValue("Media");
                System.out.println(titlu.getStringCellValue());
            } else {
                int rownr = row.getRowNum() + 1;
                Cell medie = row.createCell(6);
                medie.setCellFormula("Average(D" + rownr + ":E" + rownr + ":F" + rownr + ")");
                System.out.println(medie.getCellFormula());
            }
            System.out.println();

        }
        try {
            FileOutputStream out = new FileOutputStream("lab8ex3.xlsx");
            workbook3.write(out);
            out.close();
            System.out.println("s-a creat fisierul ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.close();
        workbook3.close();

    }

    public static void copiazafisier1() throws IOException {
        FileInputStream file = new FileInputStream(new File("lab8ex1.xlsx"));
        XSSFWorkbook workbook2 = new XSSFWorkbook(file);
        XSSFSheet sheet2 = workbook2.getSheetAt(0);

        Iterator<Row> rowIterator = sheet2.iterator();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();


            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();


                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                }
            }
            if (row.getRowNum() != 0) {
                Cell nr3 = row.getCell(5);
                Cell nr1 = row.getCell(3);
                Cell nr2 = row.getCell(4);
                double nota1 = nr1.getNumericCellValue();
                double nota2 = nr2.getNumericCellValue();
                double nota3 = nr3.getNumericCellValue();
                double media = (nota1 + nota2 + nota3) / 3.0;
                Cell medie = row.createCell(6);
                medie.setCellValue(media);
                System.out.println(medie.getNumericCellValue());
            }
            if (row.getRowNum() == 0) {
                Cell titlu = row.createCell(6);
                titlu.setCellValue("Media");
                System.out.println(titlu.getStringCellValue());
            }
            System.out.println();

        }
        try {
            FileOutputStream out = new FileOutputStream("lab8ex2.xlsx");
            workbook2.write(out);
            out.close();
            System.out.println("s-a creat fisierul ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        file.close();
        workbook2.close();

    }

    static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Studenti");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Nr crt", "Nume", "Prenume", "Nota1", "Nota2", "Nota3"});
        data.put("2", new Object[]{1, "Popa", "Andrei", 7, 8, 9});
        data.put("3", new Object[]{2, "Vercedea", "Bianca", 7, 8, 7});
        data.put("4", new Object[]{3, "Prodan", "Anamaria", 6, 9, 9});
        data.put("5", new Object[]{4, "Dumitrescu", "Paul", 9, 6, 6});
        data.put("6", new Object[]{5, "Ionescu", "Mihai", 8, 8, 9});
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("lab8ex1.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("lab8ex1.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        copiazafisier1();
        copiazafisier2();
    }
}