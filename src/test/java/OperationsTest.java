import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.polynomialcalculator.controllers.Operations;
import org.polynomialcalculator.models.Polynomial;

public class OperationsTest {
    public Polynomial setX(){
        Polynomial x = new Polynomial();
        x.getPolinom().put(0,5.0);
        x.getPolinom().put(1,2.0);
        x.getPolinom().put(2,3.0);
        x.getPolinom().put(3,1.0);
        return x;
    }
    public Polynomial setY(){
        Polynomial y = new Polynomial();
        y.getPolinom().put(0,-3.0);
        y.getPolinom().put(1,4.0);
        y.getPolinom().put(2,1.0);
        return y;
    }
    @Test
    public void test_addition(){
        Polynomial result = new Polynomial();
        result.getPolinom().put(0,2.0);
        result.getPolinom().put(1,6.0);
        result.getPolinom().put(2,4.0);
        result.getPolinom().put(3,1.0);
        assertEquals(result.getPolinom(), Operations.addition(setX(),setY()).getPolinom());
    }
    @Test
    public void test_subtraction(){
        Polynomial result = new Polynomial();
        result.getPolinom().put(0,8.0);
        result.getPolinom().put(1,-2.0);
        result.getPolinom().put(2,2.0);
        result.getPolinom().put(3,1.0);
        assertEquals(result.getPolinom(), Operations.subtraction(setX(),setY()).getPolinom());
    }
    @Test
    public void test_multiplication(){
        Polynomial result = new Polynomial();
        result.getPolinom().put(0,-15.0);
        result.getPolinom().put(1,14.0);
        result.getPolinom().put(2,4.0);
        result.getPolinom().put(3,11.0);
        result.getPolinom().put(4,7.0);
        result.getPolinom().put(5,1.0);
        assertEquals(result.getPolinom(), Operations.multiplication(setX(),setY()).getPolinom());
    }
    @Test
    public void test_division(){
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();
        quotient.getPolinom().put(1,1.0);
        quotient.getPolinom().put(0,-1.0);
        remainder.getPolinom().put(0,2.0);
        remainder.getPolinom().put(1,9.0);
        assertEquals(quotient.getPolinom(), Operations.division(setX(),setY()).getPolinom());
        assertEquals(remainder.getPolinom(), Operations.subtraction(setX(), Operations.multiplication(setY(),quotient)).getPolinom());
    }
    @Test
    public void test_derivative(){
        Polynomial result = new Polynomial();
        result.getPolinom().put(2,3.0);
        result.getPolinom().put(1,6.0);
        result.getPolinom().put(0,2.0);
        assertEquals(result.getPolinom(), Operations.derivative(setX()).getPolinom());
    }
    @Test
    public void test_integration(){
        Polynomial result = new Polynomial();
        result.getPolinom().put(4,0.25);
        result.getPolinom().put(3,1.0);
        result.getPolinom().put(2,1.0);
        result.getPolinom().put(1,5.0);
        assertEquals(result.getPolinom(), Operations.integration(setX()).getPolinom());
    }
}
