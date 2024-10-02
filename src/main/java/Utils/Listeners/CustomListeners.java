package Utils.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test is successful
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test fails
        System.out.println("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test is skipped
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to execute when a test fails but is within success percentage
        System.out.println("Test Failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before the test starts (e.g., before any test method in the class is executed)
        System.out.println("Test Context Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after all tests have run (e.g., after all test methods in the class are executed)
        System.out.println("Test Context Finished: " + context.getName());
    }

}