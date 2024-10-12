package Utils.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomIRetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3; // maximum number of retry attempts

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus())
                    + " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        return switch (status) {
            case ITestResult.SUCCESS -> "SUCCESS";
            case ITestResult.FAILURE -> "FAILURE";
            case ITestResult.SKIP -> "SKIP";
            default -> "UNKNOWN";
        };
    }
}