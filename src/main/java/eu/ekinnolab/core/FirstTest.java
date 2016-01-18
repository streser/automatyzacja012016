package eu.ekinnolab.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Kamil Tor on 18 sty 2016
 */
public class FirstTest {

	/*
	 * @Before
	 * @After
	 * 
	 * @BeforeClass
	 * 
	 * 
	 */
	
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("STARTING TESTS");
	}
	
	@Test
	public void test1() {
		System.out.println("1 test");
	}
	
	@Test
	public void test2() {
		System.out.println("2 test");
	}
	
	@Test
	public void test3() {
		System.out.println("3 test");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("ENDING TESTS");
	}
	

}
