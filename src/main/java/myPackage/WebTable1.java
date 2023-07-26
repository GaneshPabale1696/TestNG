package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	/*
	 * 1)How many rows in table?
	 * 2)How Many columns in a table?
	 * 3)Retrive the specific row/column data
	 * 4)Retrive all data from the table
	 * 5)Print Release Date,VersionNo of Java Language of Selenium
	 * */
	
	public static void main(String[] args) {

		// Launch chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1)How many rows in table?
		
		int rows=driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody/tr")).size();
		System.out.println("Total number of rows in a table:"+rows);
		
		//2)How Many columns in a table?
		int columns=driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//thead/tr/th")).size();
		System.out.println("Total number of columns in a table:"+columns);
		
		//3)Retrive the specific row/column data
		String value=driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody/tr[2]/td[1]")).getText();
		System.out.println("The value is:"+ value);
		
		//4)Retrive all data from the table
		System.out.println("Data from the table.....");
		
//		for(int r=1;r<=rows;r++)
//		{
//			for(int c=1;c<=columns;c++)
//			{
//				String data=driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody/tr["+r+"]/td["+c+"]")).getText();
//				System.out.print(data+"  ");
//			}
//			System.out.println();
//		}
		
		//5)print position,city of data
		
		for(int r=1;r<=rows;r++) {
			String names=driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody/tr["+r+"]/td[1]")).getText();
			
			if(names.equals("Jack")) {
				String position=driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody/tr["+r+"]/td[2]")).getText();
				String city=driver.findElement(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody/tr["+r+"]/td[3]")).getText();
			
				System.out.println(names+" "+position+" "+city);
			}
		
		}
		
		
		driver.quit();
		
		
	}

}
