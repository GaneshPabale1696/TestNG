package DataProviderWithExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderWithExcel {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();

		// open URl
		driver.get("http://www.google.com/");

	}

	@Test(dataProvider = "searchDataProvider")
	public void searchKeyword(String keyword) {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(keyword);
		searchBox.sendKeys(Keys.ENTER);
	}

	@DataProvider(name = "searchDataProvider")
	public Object[][] searchDataProviderMethod() {
		Object[][] searchData=getExcelData("F:\\Selenium course\\SearchData.xlsx", "sheet1");
		
		// Object[][] searchData = new Object[2][1];

		// searchData[0][0]="Taj Mahal";//row=1 col=1
		// searchData[1][0]="India Gate";//row=2 col=1
		return searchData;
	}

	public String[][] getExcelData(String fileName, String SheetName) {
		
		//declared array
		String[][] data = null;

		// open file in read open
		try {
			FileInputStream inputStrem = new FileInputStream(fileName);

			// Create XSSFWorkBook class object for excel file manipulation
			try {
				XSSFWorkbook ExcelWbook = new XSSFWorkbook(inputStrem);
				XSSFSheet ExcelWorkSheet = ExcelWbook.getSheet(SheetName);

				// get total row count
				int ttlRows = ExcelWorkSheet.getLastRowNum() + 1;

				// get total no. of cells in a row
				int ttlCells = ExcelWorkSheet.getRow(0).getLastCellNum();
				
				//initialize array
				data=new String[ttlRows-1][ttlCells];  

				for (int currentRow = 1; currentRow < ttlRows; currentRow++) {

					for (int currentCell = 0; currentCell < ttlCells; currentCell++) {
						// System.out.println();
						data[currentRow - 1][currentCell] = ExcelWorkSheet.getRow(currentRow).getCell(currentCell)
								.toString();
					}
				}

				ExcelWbook.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
