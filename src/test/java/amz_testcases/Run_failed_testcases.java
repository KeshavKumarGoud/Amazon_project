package amz_testcases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Run_failed_testcases implements IRetryAnalyzer{
    int current_count=0;
    int retry_count=1;
	@Override
	public boolean retry(ITestResult result) {
		if(current_count<retry_count)
		{
			
			current_count++;
			return true;
		}
		return false;
	}

}
