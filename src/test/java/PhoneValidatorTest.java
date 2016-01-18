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
    @Test
    @Parameters({"1234567890,true",
            "123-456-7890,true",
            "123-456-7890 x1234,true",
            "123-456-7890 ext1234,true",
            "(123)-456-7890,true",
            "123.456.7890,true",
            "123 456 7890,true"})
    public void VerifyPhoneNumber(String phoneNumber, boolean expected) {
        boolean isValid = PhoneValidator.validatePhoneNumber(phoneNumber);
        Assert.assertEquals(expected, isValid);
    }

    @Test
    @Parameters({"aa,false",
            "bb,false",
            "cc x1234,false",
            "dd ext1234,false",
            "ee,false",
            "ff,false",
            "gg,false"})
    public void VerifyInvalidPhoneNumber(String phoneNumber, boolean expected) {
        boolean isNotValid = PhoneValidator.validatePhoneNumber(phoneNumber);
        Assert.assertEquals(expected, isNotValid);
    }
}
