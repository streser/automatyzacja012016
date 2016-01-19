import org.junit.*;

/**
 * Created by Administrator on 2016-01-18.
 */
public class TestingTest  {

    @BeforeClass
    public static void shouldBePrintBeforeClass(){
        System.out.println("Before class");
        System.out.println("");
    }

    @Before
    public void shouldBePringOnlyBeforeClass(){
        System.out.println("Before");
    }

    @Test
    public void shouldPrintText(){
        System.out.println("Hello");
    }

    @Test
    public void shouldPringName(){
        System.out.println("1");
    }

    @Test
    public void shouldPringName2(){
        System.out.println("2");
    }

    @Test
    public void shouldPringName3(){
        System.out.println("3");
    }

    @After
    public void shouldBePringOnlyAfterClass(){
        System.out.println("After");
    }

    @AfterClass
    public static void shouldBePringAfterClass(){
        System.out.println("After Class");
    }
}
