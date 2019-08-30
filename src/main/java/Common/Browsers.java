package Common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Browsers extends TestNGAnnotations {

    public static void chromeBrowser() throws IOException {

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Drivers\\chromedriver.exe");

        // Headless Chorme
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

/*       driver = new ChromeDriver();
       driver.manage().window().maximize();*/

        driver.get("http://adactin.com/HotelApp/index.php");
        ExcelData.ReadData();
    }
}
