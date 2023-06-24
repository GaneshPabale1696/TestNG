package AnnotationsAttributes;

import org.testng.annotations.Test;

public class PriorityParameter {

	@Test(priority = 1)
	public void testCase1()
	{
		System.out.println("Mobile Login TestCase");
	}

	
	@Test(priority = 2)
	public void testCase2()
	{
		System.out.println("Web Login TestCase");
	}
	
	
	@Test  //execute first because priority is zero
	public void testCase3()
	{
		System.out.println("API Login TestCase");
	}
	
	
	
}
