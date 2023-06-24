package AnnotationsAttributes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EnabledDisabledAttributes {

	@Test(enabled=true) 
	public void testCase1()
	{
		System.out.println("Mobile Login TestCase");
	}

	
	@Test(enabled=true) 
	public void testCase2()
	{
		System.out.println("Web Login TestCase");
		//Assert.assertTrue(false);
	}
	
	
	@Test(enabled=false) 
	public void testCase3()
	{
		System.out.println("API Login TestCase");
	}

	
}
