package AnnotationsAttributes;

import org.testng.annotations.Test;

public class AnnotationAttributes {
	
	@Test(description = "This is testcase1.")
	public void testCase1()
	{
		System.out.println("Mobile Login TestCase");
	}

	
	@Test(description = "This is testcase2.")
	public void testCase2()
	{
		System.out.println("Web Login TestCase");
	}
	
	
	@Test(description = "This is testcase3.")
	public void testCase3()
	{
		System.out.println("API Login TestCase");
	}


	
}
