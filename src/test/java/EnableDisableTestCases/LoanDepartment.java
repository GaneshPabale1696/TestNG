package EnableDisableTestCases;

import org.testng.annotations.Test;

public class LoanDepartment {
	
	@Test
	public void MobileLoginPersonalLoan()
	{
		System.out.println("Mobile Login personal loan");
	}

	@Test(enabled=true)
	public void WebLoginPersonalLoan()
	{
		System.out.println("Web Login personal loan");
	}

	@Test(enabled=true)
	public void APILoginPersonalLoan()
	{
		System.out.println("API Login personal loan");
	}
	
	@Test
	public void MobileLoginAutomobileLoan()
	{
		System.out.println("Mobile Login Automobile loan");
	}

	
	@Test
	public void WebLoginAutomobileLoan()
	{
		System.out.println("Web Login Automobile loan");
	}
	
	@Test
	public void APILoginAutomobileLoan()
	{
		System.out.println("API Login Automobile loan");
	}
	
	
}
