import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2016-01-20.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
public class TestCucumber  {

}