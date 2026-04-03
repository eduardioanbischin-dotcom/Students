package ro.ulbs.proiectaresoftware.lab5;

public class AppLab5 {
    static void main() {
        IntCalculator calculator = new IntCalculator(10);
        IntCalculator result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + result);
    }
}
