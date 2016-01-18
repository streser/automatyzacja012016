import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class phoneValidatorTest {
    @Test
    @Parameters({"1234567890, true",
                "12345678901, false",
                "123456781, false",
                "123-456-7890, true",
                "123-456-7890 x1234, true",
                "123-456-7890 ext1234, true",
                "(123)-456-7890, true",
                "123.456.7890, true",
                "123.456..7890, false",
                "123..456.7890, false",
                "123 456 7890, true",
                "123456 7890, false",
                "123 4567890, false"
    })


    public void shouldPrintSmthWeWant1(String number, boolean valid){
        boolean result = PhoneValidator.validatePhoneNumber(number);
        assertEquals(result, valid);
    }

}
