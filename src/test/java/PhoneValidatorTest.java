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


}
