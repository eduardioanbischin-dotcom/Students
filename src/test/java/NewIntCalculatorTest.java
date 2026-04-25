import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.lab5.advanced.NewIntCalculator;

public class NewIntCalculatorTest {
    private NewIntCalculator tester;

    @BeforeEach
    public void setup() {
        tester = new NewIntCalculator();
    }

    @Test
    public void addtest() {
        tester.init(5);
        tester.add(2);
        Assertions.assertEquals(5 + 2, tester.result());
    }
    @Test
    public void subtracttest(){
        tester.init(5);
        tester.subtract(2);
        Assertions.assertEquals(5-2,tester.result());
    }
    @Test void multiplytest(){
        tester.init(5);
        tester.multiply(2);
        Assertions.assertEquals(5*2,tester.result());
    }
    @Test
    void multiply0(){
        tester.init(5);
        tester.multiply(0);
        Assertions.assertEquals(5*0,tester.result());
    }
    @Test
    public void divide0(){
        tester.init(5);
        tester.divide(0);
        Assertions.assertEquals(5/0,tester.result());
    }
}
