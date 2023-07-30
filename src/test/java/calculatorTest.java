
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class calculatorTest {
    @Test
    void OutputFour(){

        calculator calculator=new calculator();

        assertEquals(4, calculator.add(2,2));
    }
}
