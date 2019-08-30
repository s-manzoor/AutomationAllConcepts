package Listeners_Demo;


import Common.ExcelData;
import Common.ExcelUtils;
import Common.TestNGAnnotations;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import MainPackage.Login;

//@Listeners(Listeners_Demo.ListenerTest.class)  // Listeners executed before everything


public class LoginTest extends TestNGAnnotations{
    String userName;
    String invalidUser = "sajidmanz";
    String password = "webdir123";
    String projectPath = System.getProperty("user.dir");
   ExtentTest test;






    // This method should be in ExcelUtils class
   public void ExcelSetting () throws Exception {
       ExcelUtils.setExcelFile("D:/Automation/TestNGERListeners/src/main/java/Common/TestData.xlsx","Sheet1");

       userName = ExcelUtils.getCellData(1,0);
       System.out.println("UserName is :" +userName);
       password = ExcelUtils.getCellData(1,1);
       System.out.println("Password is: " +password);
       invalidUser = ExcelUtils.getCellData(2,0);
   }

  // @BeforeMethod - From .XML file

 //  @BeforeTest - from within the class

   @Test(groups = {"sanity"}) //, retryAnalyzer = Retry.class)

    public void validLogin() throws Exception {
       System.out.println("Project Path is: "+projectPath);
    // ExcelSetting();

    //   ExcelData.ReadData();


      /*  ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("BasicExtentReport.html");

        //  create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);*/

        Login log = new Login(driver);
//       ext.test= extent.createTest("Valid Login Test", "This will test valid Login credentials");
  //     ext.test.log(Status.INFO, "Starting the valid login test case again");
       //log.InputCredentials(ExcelData.list.get(0), ExcelData.list.get(1));
       for (int i=1; i<4; i++) {
         log.InputCredentials(ExcelData.excelData.get("user"+i).toString(), ExcelData.excelData.get("password"+i).toString());
         log.loginClick();
        }

//       log.InputCredentials("sajidmanzoor","webdir123R");
      //  log.InputCredentials(ExcelData.excelData.get("user1").toString(), ExcelData.excelData.get("password1").toString());

//       log.loginClick();
   //    test.pass("input valid login credentials");

     //   test.pass("Clicked on Login button");
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Explicit wait
        // Assert.assertEquals (log.loginVerification.getAttribute("value"), "Hello SajidManzoor!");
        Assert.assertTrue(log.loginVerification.isDisplayed());
     //   Assert.fail("Invalid Login details or Your Password might have expired. Click here to reset your password");
//       test.pass("Valid Login Test is passed");

    }

    @Test (groups = {"negativeTest"}) //enabled = false) //, retryAnalyzer = Retry.class)
    public void invalidLogin() throws Exception {
     //   ExcelSetting();
     //   ExcelData.ReadData();
        Login log = new Login(driver);
        //    ExtentTest test2 = extent.createTest("Extent Report 4.0 Test for Invalid Login", "This is a Extent Report for Invalid Login");
        //    test2.log(Status.INFO, "Starting the invalid login test case");

      //  log.InputCredentials(ExcelData.list.get(2), ExcelData.list.get(3));
        log.InputCredentials(ExcelData.excelData.get("user1").toString(), ExcelData.excelData.get("password1").toString());
        //  test2.pass("input invalid login credentials");
        log.loginClick();
        //  test2.pass("Clicked on Login button");
        Assert.assertEquals(log.loginError.getText(), "Invalid Login details or Your Password might have expired. Click here to reset your password");
        //    test2.pass("Invalid Login Test is passed");
    }

    @Test (dependsOnMethods = "validLogin", groups = {"sanity"}) //, retryAnalyzer = Retry.class)
    public void Logout() {
        //   ExtentTest test3 = extent.createTest("Logout Test", "Logout Test of the AdactIn");
        //  test3.log(Status.INFO, "This is Logout Test Report");

        Login log = new Login(driver);
        log.Logout();
        //  test3.pass("Logout Button is clicked successfully");
        //  log.clickChangePassword();
        Assert.assertEquals(log.logoutMessage.getText(),"You have successfully logged out. Click here to login again");
        //  test3.pass("Logout Method is passed...");
    }

}