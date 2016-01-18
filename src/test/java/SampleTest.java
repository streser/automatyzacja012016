import org.junit.Test;

public class SampleTest {

    /*
        One test for each annotation

        @Before x1
        @After x1

        @BeforeClass + public static void x1
        @AfterClass + public static void x1

        @Test x3
    */

    @Test
    public void shouldPrintText() {
        System.out.println("shouldPrintText");
    }
}