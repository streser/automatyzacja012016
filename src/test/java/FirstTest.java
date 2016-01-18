

import junitparams.*;

import org.junit.*;
import org.junit.runner.RunWith;

/**
 * Created by Kamil Tor on 18 sty 2016
 */

@RunWith(JUnitParamsRunner.class)
public class FirstTest {
	
	
	@Test
	@Parameters({ "430989&*43098, false",
				  "(123)-456-7890, true",
				  "(123)-456-7.890, false"})
	public static void testPhoneValidator(String phoneNumber, boolean result) {
		Assert.assertEquals(validatePhoneNumber(phoneNumber) , result);
	}
	
	private static boolean validatePhoneNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;
    }
}
