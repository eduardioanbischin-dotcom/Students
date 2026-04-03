package ro.ulbs.proiectaresoftware.lab5.advanced;

public class Lab5Adv {
    static void main() {
        NewIntCalculator a=new NewIntCalculator();
        DoubleCalculator b=new DoubleCalculator();
        Integer i=(Integer) a.init().add(10).add(5).subtract(3).multiply(2).result();
        Double d=(Double) b.init().add(10.0).add(5.0).subtract(3.3).multiply(2.2).result();
    }
}
