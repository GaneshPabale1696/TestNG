package RetryLogicDemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	//counter to keep track of retry attempts
	int countForRetryAttempts = 0;
	
	//set max limit for retry
	int setMaxLimitForRetry = 3;
	
	//Method to retry failed test cases
	public boolean retry(ITestResult result) {
	
		if(!result.isSuccess())
		{
			if(countForRetryAttempts<setMaxLimitForRetry) {
				countForRetryAttempts++;
				return true;
			}
		}
		return false;
	}
	

}
