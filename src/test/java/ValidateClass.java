import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.polynomialcalculator.controllers.Validators;
import org.polynomialcalculator.models.Polynomial;

import java.util.HashMap;

public class ValidateClass {
    public Polynomial setX(){
        Polynomial x = new Polynomial();
        x.getPolinom().put(0,5.0);
        x.getPolinom().put(1,2.0);
        x.getPolinom().put(2,3.0);
        x.getPolinom().put(3,1.0);
        return x;
    }
    @Test
    public void valid_input(){
        String s = "x^3+3x^2+2x^1+5";
        assertEquals(setX().getPolinom(), Validators.parse_a_string(s));
    }
    @Test
    public void valid_output(){
        String s = "5.0+2.0x+3.0x^2+x^3";
        assertEquals(s,Validators.parse_a_polinom((HashMap<Integer, Double>) setX().getPolinom()));
    }
}
