package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursier extends Student{
    double cuantumbursa;

    public StudentBursier(int numarMatricol, String prenume, String nume, String formatieDeStudiu ,float nota,double cuantumbursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumbursa = cuantumbursa;
    }
public double getCuantumbursa(){
        return this.cuantumbursa;
}
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(cuantumbursa, that.cuantumbursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumbursa);
    }
    @Override
    public String toString() {
        return  numarMatricol+" "+ prenume + ' ' +
                nume +
                " " + formatieDeStudiu + " " +
                " " + nota+" "+cuantumbursa ;
    }


}
