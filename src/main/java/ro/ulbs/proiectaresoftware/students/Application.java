package ro.ulbs.proiectaresoftware.students;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Application {





    static void main() {
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
        Path inputnote=Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\src\\note.anon.txt");
        Path input = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\students.in.txt");
        Path output = Paths.get("C:\\Users\\Edi\\IdeaProjects\\Students\\students.out.txt");
        try {

            List<String> linii = Files.readAllLines(input);
List<String> note=Files.readAllLines(inputnote);

            List<Student> listaStudenti = new ArrayList<>();
            HashMap<Integer,Student> Studenti=new HashMap<>();
            for (String linie : linii) {

                String[] date = linie.split(",");
                int nr_matricol = Integer.parseInt(date[0].trim());
                String Nume = date[2].trim();
                String Prenume = date[1].trim();
                String Grupa = date[3].trim();

                listaStudenti.add(new Student(nr_matricol, Prenume, Nume, Grupa));
                 Studenti.put(nr_matricol,new Student(nr_matricol, Prenume, Nume, Grupa));
            }
               for(String n:note){
             String[]date2=n.split(",");
              int nr_matricol=Integer.parseInt(date2[0].trim());
              float notes=Float.parseFloat(date2[1].trim());
Student s=Studenti.get(nr_matricol);
if(s!=null)
s.setNota(notes);

             }
for (Map.Entry<Integer,Student> stu :Studenti.entrySet()) {
            System.out.println(stu.getValue().toString());
        }
            writeLargerTextFile(listaStudenti, output);

        } catch (IOException e) {
            e.printStackTrace();
        }

}
public static void writeLargerTextFile(List<Student> studenti, Path path) throws IOException {
    List<String> deScris = new ArrayList<>();
    for (Student s : studenti) {

        deScris.add(s.getNumarMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
    }
    Files.write(path, deScris);
}}



