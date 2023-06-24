package AnnotationsAttributes;

import org.testng.annotations.Test;

public class TimeOuts {

	@Test(timeOut = 200)
	public void testCase1() throws InterruptedException
	{
		Thread.sleep(400);
		System.out.println("Mobile  Login TestCase");
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
