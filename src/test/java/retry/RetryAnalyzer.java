package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retryCount = 0;
	
	@Override
    public boolean retry(ITestResult result) {
		
		if (retryCount < 1) {
		    retryCount++;
		    return true;
		}
        return false;
    }
	
}
