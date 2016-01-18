import org.junit.*;

public class piotrTest {
/*
@Before
@After

@BeforeClass musi byc public static void bo obiekt jeszcze nie jest stworzony obiekt
@AfterClass musi byc public static void bo obiekt jeszcze nie jest stworzony obiekt

@Test
Junit losowa wykonywalnosc testow - trzeba zapewnic zeby testy byly wykonywalne samodzielnie bez zaleznosci

*/

    @Before
    public void beforeTestSamo(){
        System.out.println("@Before");
    }

    @After
    public void afterTestSamo(){
        System.out.println("@After");
    }

    @BeforeClass
    public static void beforeClassTestSamo(){
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void afterClassTestSamo(){
        System.out.println("@AfterClass");
    }



    @Test
    public void shouldPrintSmthWeWant1(){
        System.out.println("say hello 1");
    }

    @Test
    public void shouldPrintSmthWeWant2(){
        System.out.println("say hello 2");
    }

    @Test
    public void shouldPrintSmthWeWant3(){
        System.out.println("say hello 3");
    }

}
