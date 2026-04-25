
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.students.StudentBursier;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AplicatieCuBursaTest {
    static void main(String[] args) {
        AplicatieCuBursaTest instanta = new AplicatieCuBursaTest();
        List<StudentBursier> lista = instanta.genereaza();
        for (StudentBursier student : lista) {
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------");
        List<StudentBursier> sortata = instanta.sorteaza(lista);
        for (StudentBursier student : sortata) {
            System.out.println(student);
        }
    }

    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        lista.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 780.80));
        lista.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 100.00));
        return lista;
    }

    public List<StudentBursier> genereaza2(List<StudentBursier> lst) {

        lst.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));

        lst.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));

        lst.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));

        lst.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 100.00));

        lst.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 780.80));

        return lst;
    }
    public List<StudentBursier> sorteaza(List<StudentBursier> lst) {

        lst.sort(Comparator.comparing(StudentBursier::getFormatieDeStudiu)
                .thenComparing(StudentBursier::getNume)
                .thenComparing(StudentBursier::getPrenume)
                .thenComparingDouble(StudentBursier::getNota)
                .thenComparingDouble(StudentBursier::getCuantumbursa));


        return lst;
    }

    @Test
    public void testsort() {
        List<StudentBursier> lista = new ArrayList<>();
        List<StudentBursier> lst = new ArrayList<>();
        lista=genereaza();
        lst=genereaza2(lst);
        lista=sorteaza(lista);
        for (int i = 0; i < lista.size() ; i++) {
            StudentBursier s1 = lst.get(i);
            StudentBursier s2 = lista.get(i );
            Assertions.assertEquals(s1.getFormatieDeStudiu(), s2.getFormatieDeStudiu());
            Assertions.assertEquals(s1.getPrenume(), s2.getPrenume());
            Assertions.assertEquals(s1.getNume(), s2.getNume());
            Assertions.assertEquals(s1.getNota(), s2.getNota());
            Assertions.assertEquals(s1.getCuantumbursa(), s2.getCuantumbursa());
        }
    }
}
