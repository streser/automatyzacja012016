import junit.framework.Assert;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2016-01-18.
 */
@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {
    /*
        Phone number 1234567890 validation result: true
        Phone number 123-456-7890 validation result: true
        Phone number 123-456-7890 x1234 validation result: true
        Phone number 123-456-7890 ext1234 validation result: true
        Phone number (123)-456-7890 validation result: true
        Phone number 123.456.7890 validation result: true
        Phone number 123 456 7890 validation result: true
     */
    @Test
    @Parameters({"1234567890", "123-456-7890", "123-456-7890", "123-456-7890", "(123)-456-7890", "123.456.7890", "123 456 7890"})
    public void shouldBeCorrectPhone(String phone){
        PhoneValidator.validatePhoneNumber(phone);
    }

    @Test
    @Parameters({"null", "12", "124356543778678968976", "123:456:7890"})
    public void shouldBeIncorrectPhone(String phone){
        Assert.assertFalse(PhoneValidator.validatePhoneNumber(phone));
    }
}
