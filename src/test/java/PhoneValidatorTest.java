import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;


@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {

    @Test
    @Parameters({"0123456789", "888 888 9990"})
    public void validatePhoneNumberTrueTest(String number){
        assertTrue(PhoneValidator.validatePhoneNumber(number));
    }
    @Test
    @Parameters({"01234567890000000", "9990"})
    public void validatePhoneNumberFalseTest(String number){
        assertFalse(PhoneValidator.validatePhoneNumber(number));
    }
}
