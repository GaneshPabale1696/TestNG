package AnnotationsAttributes;

import org.testng.annotations.Test;

public class GroupsAttributes {
	
	@Test (groups="software company")
	public void infosys()
	{
		System.out.println("infosys");
	}

	
	@Test (groups="software company")
	public void wipro()
	{
		System.out.println("Tcs");
		//Assert.assertTrue(false);
	}
	
	
	@Test(groups = "automobile")
	public void Maruti()
	{
		System.out.println("Maruti");
	}


	@Test(groups = "automobile")
	public void Tata()
	{
		System.out.println("Tata");
	}
	
	
}
