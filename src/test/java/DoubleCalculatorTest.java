import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.lab5.advanced.DoubleCalculator;

public class DoubleCalculatorTest {
    private DoubleCalculator tester;
    @BeforeEach
    public void setup(){
    tester=new DoubleCalculator();}
    @Test
    public void addtest(){
        tester.init(5.5);
        tester.add(1.5);
        Assertions.assertEquals(5.5+1.5,tester.result());
    }
    @Test
    public void subtracttest(){
        tester.init(5.5);
        tester.subtract(1.5);
        Assertions.assertEquals(5.5-1.5,tester.result());
    }
    @Test
    public void multiplytest(){
        tester.init(5.5);
        tester.multiply(1.5);
        Assertions.assertEquals(5.5*1.5,tester.result());
    }
    @Test
    void multiply0(){
        tester.init(5.5);
        tester.multiply(0.0);
        Assertions.assertEquals(5.5*0.0,tester.result());
    }
    @Test
    public void divide0(){
        tester.init(5.5);
        tester.divide(0.0);
        Assertions.assertEquals(5.5/0.0,tester.result());
    }
}
