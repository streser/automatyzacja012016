import org.junit.*;

/**
 * Created by Administrator on 2016-01-18.
 */
public class FirstTest {

    @Test //adnotacja []atrybuty
    /*
    @Before @After [TestFixture]
     */
    public void shouldPrintText1() {
        System.out.println("Hello1");
    }

    @Test //adnotacja []atrybuty
    /*
    @Before @After [TestFixture]
     */
    public void shouldPrintText2() {
        System.out.println("Hello2");
    }

    @Test //adnotacja []atrybuty
    /*
    @Before @After [TestFixture]
     */
    public void shouldPrintText3() {
        System.out.println("Hello3");
    }


    @Before
    public void shouldPrintTextSecond() {
        System.out.println("Hello second");
    }

    @After
    public void shouldPrintTextThird() {
        System.out.println("Hello third");
    }

    @BeforeClass
    public static void shouldPrintTextFourth() {
        System.out.println("Hello fourth");
    }

    @AfterClass
    public static void shouldPrintTextFifth() {
        System.out.println("Hello fifth");
    }
}
