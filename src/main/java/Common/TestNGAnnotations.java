package Common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.io.IOException;

public class TestNGAnnotations {

    public static WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static Browsers browser;
    public PropertyManager PM;
//    String baseURL = PropertyManager.get
static ExtentTest test;
    static ExtentReports report;

    @BeforeSuite
    public void beforeSuite(){
        htmlReporter = new ExtentHtmlReporter("ListernsExtentReport.html");
        //  System.out.println("This is Before Suite Method...");
        //    create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
     //  test = report.startTest("ExtentDemo");

        //  extent = getExtent();

        extent.attachReporter(htmlReporter);

    }

    @Parameters("browserName")
    @BeforeClass (alwaysRun = true)
    public void setup(String browserName) throws IOException {

        /*htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
        System.out.println("This is Before class Setup() Method...");
        //    create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        //  extent = getExtent();
        extent.attachReporter(htmlReporter);
*/

   /*     System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://adactin.com/HotelApp/index.php");
        ExcelData.ReadData();
   */

   System.out.println("Browser name is :" + browserName);
   if(browserName.equalsIgnoreCase("chrome")){

      // browser.
       System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");

     // Headless Chorme
       ChromeOptions options = new ChromeOptions();
       options.addArguments("headless");
       driver = new ChromeDriver(options);

/*       driver = new ChromeDriver();
       driver.manage().window().maximize();*/

    //   driver.get("http://adactin.com/HotelApp/index.php");
      String BaseURL = PM.getInstance().getURL();
       driver.get(BaseURL);
       System.out.println(BaseURL);
       ExcelData.ReadData();

   }
   else if (browserName.equalsIgnoreCase("firefox")) {
    /*   System.setProperty("webdriver.gecko.driver", "D:\\Automation\\Selenium Drivers\\geckodriver.exe");
       driver = new FirefoxDriver();
       driver.manage().window().maximize();
*/

    // Headless Firefox
       FirefoxBinary firefoxBinary = new FirefoxBinary();
       firefoxBinary.addCommandLineOptions("--headless");
       System.setProperty("webdriver.gecko.driver", "D:\\Automation\\Selenium Drivers\\geckodriver.exe");
       FirefoxOptions options = new FirefoxOptions();
       options.setBinary(firefoxBinary);
       driver = new FirefoxDriver(options);

       driver.get("http://adactin.com/HotelApp/index.php");
       ExcelData.ReadData();
   }
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        //  extent.flush();
        System.out.println("This is After Class tearDown() Method...");
    }


    @AfterSuite
    public void afterSuite(){
        extent.flush();
        //  System.out.println("This is After Suite Method...");
    }


}
