package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {

    static void main(String[] args) throws IOException {
        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        /*
        System.out.println(s1.getNumarMatricol()+" "+ s1.getNume()+ " "+ s1.getPrenume()+" "+s1.getFormatieDeStudiu());
        System.out.println(s2.getNumarMatricol()+" "+ s2.getNume()+ " "+ s2.getPrenume()+" "+s2.getFormatieDeStudiu());
        System.out.println(s3.getNumarMatricol()+" "+ s3.getNume()+ " "+ s3.getPrenume()+" "+s3.getFormatieDeStudiu());
        System.out.println(s4.getNumarMatricol()+" "+ s4.getNume()+ " "+ s4.getPrenume()+" "+s4.getFormatieDeStudiu());
        System.out.println(s5.getNumarMatricol()+" "+ s5.getNume()+ " "+ s5.getPrenume()+" "+s5.getFormatieDeStudiu());
        List<Student> st=new ArrayList<>();
        */

        List<Student> st = new ArrayList<>();
        st.add(s1);
        st.add(s2);
        st.add(s3);
        st.add(s4);
        st.add(s5);
        Set<Student>studenti=new HashSet<>();
        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);
        studenti.add(s5);
imparteInDouaFormatii(studenti,"TI21/1","TI22/1");
        System.out.println(studenti);
        /*
        for(Student s : st ){
            System.out.println(s.getNumarMatricol()+" "+ s.getNume()+ " "+ s.getPrenume()+" "+s.getFormatieDeStudiu());
        }

        Student b=new Student(120,"Alis","Popa","TI21/2");
        Student c=new Student(112,"Maria","Popa","TI21/1");
*/
        Student b = new Student(120, "Alis", "Popa", "TI21/2");
        Student c = new Student(112, "Maria", "Popa", "TI21/1");
        /*
        System.out.println(b.listacontine(st));
        System.out.println(c.listacontine(st));
*/
        Path inputnote = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\src\\note.anon.txt");
        Path input = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\students.in.txt");
        Path output = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\students.out.txt");
        Path outbursieri = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\src\\bursieri.out.txt");
        HashMap<Integer, Student> tineri = new HashMap<>();
        try {

            List<String> linii = Files.readAllLines(input);
            List<String> note = Files.readAllLines(inputnote);

            List<Student> listaStudenti = new ArrayList<>();

            for (String linie : linii) {

                String[] date = linie.split(",");
                int nr_matricol = Integer.parseInt(date[0].trim());
                String Nume = date[2].trim();
                String Prenume = date[1].trim();
                String Grupa = date[3].trim();

                listaStudenti.add(new Student(nr_matricol, Prenume, Nume, Grupa));
                tineri.put(nr_matricol, new Student(nr_matricol, Prenume, Nume, Grupa));
            }
            for (String n : note) {
                String[] date2 = n.split(",");
                int nr_matricol = Integer.parseInt(date2[0].trim());
                float notes = Float.parseFloat(date2[1].trim());
                Student s = tineri.get(nr_matricol);
                // if (s != null)
                //       s.setNota(notes);

            }

            for (Map.Entry<Integer, Student> stu : tineri.entrySet()) {
                System.out.println(stu.getValue().toString());


            }
            writeLargerTextFile(listaStudenti, output);
            List<StudentBursier> bursieri = new ArrayList<StudentBursier>();
            bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
            bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
            bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
            bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 780.80));
            writeLargerTextFile(bursieri, outbursieri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        float notaM = gasesteNota("Bianca", "Popescu", tineri);
        float notaN = gasesteNota("Ioan", "Popa", tineri);

        System.out.println("Nota Bianca: " + notaM);
        System.out.println("Nota Ioan: " + notaN);
        exportaexcel(st);
        List<Student> stexcel = new ArrayList<>();
        extrageexcel(stexcel);
    }

    public static float gasesteNota(String prenume, String nume, HashMap<Integer, Student> Studenti) {
        HashMap<String, Student> cautareRapida = new HashMap<>();

        for (Student s : Studenti.values()) {
            String cheie = s.getPrenume() + "-" + s.getNume();
            cautareRapida.put(cheie, s);
        }

        String cheieCautata = prenume + "-" + nume;
        Student gasit = cautareRapida.get(cheieCautata);
        return (gasit != null) ? gasit.getNota() : 0.0f;
    }

    public static void writeLargerTextFile(List<? extends Student> studenti, Path path) throws IOException {
        List<String> deScris = new ArrayList<>();
        for (Student s : studenti) {

            deScris.add(s.toString());
        }
        Files.write(path, deScris);


    }

    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(st.getNumarMatricol(), st.getPrenume(), st.getNume(), nouaFormatieDeStudiu);
    }


    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String f1, String f2) {
        Set<Student> setnou = new HashSet<>();
        int nrstudenti = studenti.size();
        int jumatate = nrstudenti / 2;
        if (nrstudenti % 2 != 0) {
            jumatate++;
        }

        int i = 0;
        for (Student s : studenti) {
            if (i < jumatate) {
                setnou.add(schimbaFormatia(s, f1));
            } else {

                setnou.add(schimbaFormatia(s, f2));
            }
            i++;
        }

        return setnou;

    }

    public static void exportaexcel(List<Student> st) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Studenti");


        int rownum = 0;
        Row row = sheet.createRow(rownum++);
        Cell nrmatr = row.createCell(0);
        nrmatr.setCellValue("NrMatricol");
        Cell nume = row.createCell(1);
        nume.setCellValue("Nume");
        Cell prenume = row.createCell(2);
        prenume.setCellValue("prenume");
        Cell Formatie = row.createCell(3);
        Formatie.setCellValue("Formatie de studiu");
        for (Student student : st) {
            Row row2 = sheet.createRow(rownum++);
            int cellnum = 0;

            Cell Nrmatr = row2.createCell(cellnum++);
            Nrmatr.setCellValue(student.getNumarMatricol());
            Cell Nume = row2.createCell(cellnum++);
            Nume.setCellValue(student.getNume());
            Cell Prenume = row2.createCell(cellnum++);
            Prenume.setCellValue(student.getPrenume());
            Cell Formatiedestudiu = row2.createCell(cellnum++);
            Formatiedestudiu.setCellValue(student.getFormatieDeStudiu());
        }

        try {
            FileOutputStream out = new FileOutputStream(new File("lab8students.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("lab8students.xlsx written successfully on disk.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> extrageexcel(List<Student> st) throws IOException {
        FileInputStream file = new FileInputStream(new File("lab8students.xlsx"));
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
                Cell Prenume = row.getCell(2);
                Cell NrMatr = row.getCell(0);
                Cell Nume = row.getCell(1);
                Cell Formatie = row.getCell(3);
                String prenume = Prenume.getStringCellValue();
                double matr = NrMatr.getNumericCellValue();
                String nume = Nume.getStringCellValue();
                String formatie = Formatie.getStringCellValue();
                Student student = new Student((int) matr, prenume, nume, formatie);
                st.add(student);
            }

            System.out.println();

        }
        workbook2.close();
        file.close();
        return st;
    }
}




