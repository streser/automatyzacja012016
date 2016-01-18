import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;

public class FirstTest {

    @Before
    public void printBefore(){
        System.out.println("@Before");
    }

    @BeforeClass
    public static void printBeforeClass(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void printAfterClass(){
        System.out.println("@AfterClass");
    }

    @After
    public void printAfter(){
        System.out.println("After");
    }

    @Test
    public void shouldPrintAfterClassTest(){
        System.out.println("1");
    }

    @Test
    public void shouldPrintBeforeClassTest(){
        System.out.println("2");
    }

    @Test
    public void shouldPrintBeforeTest(){
        System.out.println("3");
    }
}
