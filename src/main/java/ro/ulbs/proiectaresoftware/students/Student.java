package ro.ulbs.proiectaresoftware.students;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }



    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  hashCode()==student.hashCode();
    }


    public int hashCode() {
        return Objects.hash(numarMatricol);
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }


        boolean listacontine(List <Student> st){
        HashSet<Student> studentHashSet=new HashSet<Student>(st);
        if(studentHashSet.contains(this)){

            return true;

        }

        else return false;

    }
}
