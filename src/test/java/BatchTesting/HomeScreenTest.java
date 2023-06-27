package BatchTesting;

import org.testng.annotations.Test;

public class HomeScreenTest {
	
	@Test
	public void LaunchApplication()
	{
		System.out.println("Application Launched Passed.");
	}

	
	@Test
	public void VerifyTitle()
	{
		System.out.println("Verify Title Passed.");
	}

	@Test
	public void VerifyLogo()
	{
		System.out.println("Verify Logo Passed.");
	}

	
}
