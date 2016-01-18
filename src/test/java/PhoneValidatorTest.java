import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class PhoneValidatorTest {

    @Test
    @Parameters({"1234567890","123-456-7890"})
    public void Validate(String phoneNumber){

     Assert.assertTrue(PhoneValidator.validatePhoneNumber(phoneNumber));
    }

    @Test
    @Parameters({"12yyuu34567890","123-45uyuuu6-7890"})
    public void Validate_false(String phoneNumber){

        Assert.assertFalse(PhoneValidator.validatePhoneNumber(phoneNumber));
    }

}
