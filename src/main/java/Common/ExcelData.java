package Common;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Returing Execl Data to Test Method with List or HashMap

public class ExcelData extends TestNGAnnotations{


    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell userCell;
    static XSSFCell passwordCell;
    public static List<String> list = new ArrayList<String>(); // ArrayList for storing Excel data
    public static Map excelData = new HashMap();


    public static Map ReadData() throws IOException {

        // Import excel sheet.
        File src = new File("D:/Automation/TestNGERListeners/src/main/java/Common/TestData.xlsx");

        // Load the file.
        FileInputStream finput = new FileInputStream(src);

        // Load he workbook.
        workbook = new XSSFWorkbook(finput);

        // Load the sheet in which data is stored.
        sheet = workbook.getSheetAt(0);

        for (int i = 1; i < 4; i++) {
            // Import data for Email.
         /*   cell = sheet.getRow(i).getCell(0);
            cell.setCellType(CellType.STRING);
            list.add(cell.getStringCellValue());
            //   driver.findElement(By.id("username")).sendKeys(cell.getStringCellValue());
            System.out.println("Username value is :" + cell);

            // Import data for password.
            cell = sheet.getRow(i).getCell(1);
            cell.setCellType(CellType.STRING);
            //  driver.findElement(By.id("password")).sendKeys(cell.getStringCellValue());
            list.add(cell.getStringCellValue());
            System.out.println("Password is :" + cell);
*/

            userCell = sheet.getRow(i).getCell(0);
            userCell.setCellType(CellType.STRING);
            list.add(userCell.getStringCellValue());
            //   driver.findElement(By.id("username")).sendKeys(cell.getStringCellValue());
            System.out.println("Username value is :" + userCell);
            excelData.put("user"+(i),userCell.getStringCellValue());

            // Import data for password.
            passwordCell = sheet.getRow(i).getCell(1);
            passwordCell.setCellType(CellType.STRING);
            //  driver.findElement(By.id("password")).sendKeys(cell.getStringCellValue());
            list.add(passwordCell.getStringCellValue());
            System.out.println("Password is :" + passwordCell);

            excelData.put("password" +(i), passwordCell.getStringCellValue());

        }
        System.out.println("List content is:" + list);
        System.out.println("Map Elements : " );
        System.out.print(excelData);

       // return list;
        return excelData;
    }
}
