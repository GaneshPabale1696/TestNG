package Innovationcount;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class InnovacationCountDemo {
	
	@Test(invocationCount = 5)
	public void testMethod1(ITestContext context) {
	int currentInvocationCount=	context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Executing:" +currentInvocationCount);
		System.out.println("test Method1.........");
	}


	@Test(invocationCount = 3)
	public void testMethod2(ITestContext context) {
		int currentInvocationCount=	context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("Executing:" +currentInvocationCount);
		System.out.println("test Method2.........");
	}

	
}
