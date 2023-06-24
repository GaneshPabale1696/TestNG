package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

	public void onStart(ITestContext context) {

		System.out.println("on start method is invoked....");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:"+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		
		System.out.println("on finished method is invoked....");
	}

	

	

	public void onTestSkipped(ITestResult result) {

		System.out.println("Name of test method skipped:"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Name of test method successfully executed:"+result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {

		System.out.println("Name of test method timeout filure executed:"+result.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method Start the test method:"+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	
}
