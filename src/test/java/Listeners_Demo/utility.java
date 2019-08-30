package Listeners_Demo;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// This class is for failure test screen shot capturing

public class utility {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");

    public static String captureScreenshot(WebDriver driver, String screenshotname){

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String encodedBase64 = null;
        FileInputStream fileInputStreamReader = null;

        try {
            fileInputStreamReader = new FileInputStream(sourceFile);
            byte[] bytes = new byte[(int)sourceFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

            String dest = System.getProperty("user.dir")+"//Test-ScreenShots//"+screenshotname.trim()+".png";

            File destination = new File(dest);
            FileUtils.copyFile(sourceFile, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64,"+encodedBase64;

        /*TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);

        String dest = System.getProperty("user.dir")+"//Test-ScreenShots//"+screenshotname+".png";

        File target = new File(dest);
        try {
            FileUtils.copyFile(src, target);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dest;*/

       /* try
        {
            TakesScreenshot screenshot =(TakesScreenshot)driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);

            //           FileUtils.copyFile(source, new File("./Screenshots/"+screenshotname+".png"));
          //   FileHandler.copy(source, new File("D:\\"+screenshotname+".png"));
            FileHandler.copy(source, new File("D:\\"+screenshotname+".png"));
          *//*  String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotname+".png";
            File finalDestination = new File(destination);
            FileHandler.copy(source, finalDestination);*//*

            System.out.println("Screenshot Taken");

        }catch(Exception excep)
        {
            System.out.println("Throwing exception while taking screenshot" +excep.getMessage());
        }

        return screenshotname;
    }*/

    }

    public static String generateFileName(ITestResult result){
        Date date = new Date();
        String fileName = result.getName()+ "_" + dateFormat.format(date);
        return fileName;

    }

}