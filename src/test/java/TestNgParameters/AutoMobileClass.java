package TestNgParameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutoMobileClass {

	@Parameters({"AutoMobileName"})
	@Test
	public void Testcase1(String name)
	{
		System.out.println(name);
	}
	
}
