package ro.ulbs.proiectaresoftware.students;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Student {
protected int numarMatricol;
    protected String prenume;
    protected String nume;
    protected String formatieDeStudiu;
    protected float nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu,float  nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;

        this.nota=nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return  hashCode()==student.hashCode();
    }

    @Override
    public String toString() {
        return  numarMatricol+" "+ prenume + ' ' +
                  nume +
                " " + formatieDeStudiu + " " +
                " " + nota ;
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

    public float getNota() {
        return nota;
    }

    boolean listacontine(List <Student> st){
        HashSet<Student> studentHashSet=new HashSet<Student>(st);
        if(studentHashSet.contains(this)){

            return true;

        }

        else return false;

    }
}
