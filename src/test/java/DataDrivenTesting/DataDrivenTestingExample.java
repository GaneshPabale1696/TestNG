 package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTestingExample {

	public static void main(String[] args) {

		XSSFWorkbook ExcelWbook = null;
		XSSFSheet ExcelWorkSheet;
		// XSSFRow Row;
		// XSSFCell Cell;

		// create an object of file class to open file
		File excelFile = new File("F:\\Selenium course\\TestDataFile.xlsx");

		FileInputStream inputStream = null;
		// create an object of FileInputStream to read data from file
		try {
			inputStream = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// create object of XSSFWorkbook to handle excel file
		try {
			ExcelWbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// to access workbook sheet
		ExcelWorkSheet = ExcelWbook.getSheetAt(0);

		// get total row count
		int ttlRows = ExcelWorkSheet.getLastRowNum() + 1;

		// get total no. of cells in a row
		int ttlCells = ExcelWorkSheet.getRow(0).getLastCellNum();

		for (int currentRow = 0; currentRow < ttlRows; currentRow++) {
			// Launch chrome browser
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(ops); // launch chrome

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			driver.manage().window().maximize();

			driver.get("https://www.saucedemo.com/");

			// find username
			driver.findElement(By.id("user-name")).sendKeys(ExcelWorkSheet.getRow(currentRow).getCell(0).toString());

			// find password
			driver.findElement(By.id("password")).sendKeys(ExcelWorkSheet.getRow(currentRow).getCell(1).toString());
			
			//Click on login button
			driver.findElement(By.id("login-button")).click();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//				for(int currentCell=0;currentCell<ttlCells;currentCell++)
//				{
//				System.out.print(ExcelWorkSheet.getRow(currentRow).getCell(currentCell).toString());
//				System.out.print("\t");
//				}
//				System.out.println("\n");
			driver.quit();
		}

		try {
			ExcelWbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
