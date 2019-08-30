package Listeners_Demo;
// Extent Report Listeners Class

import Common.TestNGAnnotations;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.IOException;

import static Listeners_Demo.utility.generateFileName;

public class ListenerTest extends Common.TestNGAnnotations implements ITestListener {
    public static ExtentTest test;
    ExtentReports reports;


    //  public static ExtentTest test1 = extent.createTest("Listeners Report", "This will Listeners Extent Report:");
    // test.log(Status.INFO, "Starting the valid login test case again");


    public void onFinish(ITestContext Result)
    {
        System.out.println("After Suite Method is finished in Listener...");
    }


    public void onStart(ITestContext Result)
    {
        System.out.println("Before Suite Method is starting in Listener...");
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
    {

    }

    // When Test case get failed, this method is called.

    public void onTestFailure(ITestResult Result) {
        String screenShot = utility.captureScreenshot(driver,generateFileName(Result));
        test=extent.createTest(Result.getName()+" Test", "This will test "+Result.getName() + " Test case");
        if (Result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, Result.getName());
            test.log(Status.FAIL,Result.getThrowable());
            try {
                test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      //  reports.flush();
        //driver.close();
       /* System.out.println("The name of the testcase failed is :"+Result.getName());
        ExtentTest test2 = extent.createTest(Result.getName()+" Test", "This will test "+Result.getName() + " Test case");
        test2.log(Status.INFO, "Starting " + Result.getName()+ " test case");
        try {
            test2.fail("Testcase: " +Result.getName()+ " is failed..."+shot.addScreenCaptureFromPath(screenShot));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*if(ITestResult.FAILURE==Result.getStatus())
        {
            utility.captureScreenshot(driver, Result.getName());
            try {

                test2.addScreenCaptureFromPath("D:\\validLogin.png","validLogin"); // "D:\\"+screenshotname+".png"

                System.out.println("Screen shot attached to extent report");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

*/        //test2.log(LogS)

//        extent.flush();
    }

    // When Test case get Skipped, this method is called.

    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("The name of the testcase Skipped is :"+Result.getName());
        ExtentTest test2 = extent.createTest(Result.getName()+" Test", "This will test "+Result.getName() + " Test case");
        test2.log(Status.INFO, "Starting " + Result.getName()+ " test case");
        test2.skip("Testcase: " +Result.getName()+ " is skipped...");
        extent.flush();

    }

    // When Test case get Started, this method is called.

    public void onTestStart(ITestResult Result)
    {
        System.out.println(Result.getName()+" test case started");
    }

    // When Test case get passed, this method is called.

    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("The name of the testcase passed is :"+Result.getName());
        ExtentTest test1 = extent.createTest(Result.getName()+" Test", "This will test "+Result.getName() + " Test case");
        test1.log(Status.INFO, "Starting " + Result.getName()+ " test case");
        test1.pass("Testcase: " +Result.getName()+ " is passed....");
        extent.flush();
    }

}


