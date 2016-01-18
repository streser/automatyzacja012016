/**
 * Created by Administrator on 2016-01-18.
 */
import org.junit.*;

public class Mash1 {
    @Test
    public void Display1(){
        System.out.println("Hello M");
    }

    @Test
    public void Display2(){
        System.out.println("Hi");
    }

    @Before
    public void Test1(){
        System.out.println("Test1");
    }

    @After
    public void Test2(){

        System.out.println("Test2");
    }

    @BeforeClass
    public static void Test3(){
        System.out.println("Test3");
    }

    @AfterClass
    public static void Test4(){
        System.out.println("Test4");
    }

}

