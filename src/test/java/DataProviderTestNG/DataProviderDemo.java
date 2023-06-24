package DataProviderTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@Test(dataProvider = "SearchDataSet",dataProviderClass =DataProviderMethod.class)
	public void TestCaseGoogleSearch(String country,String monument)
	{
				// Launch chrome driver
				WebDriverManager.chromedriver().setup();
				ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(ops); // launch chrome

				driver.get("https://www.google.com/");
				
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				
				WebElement search=driver.findElement(By.xpath("//textarea[@name='q']"));
				search.sendKeys(country+" "+monument);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				driver.findElement(By.xpath("//input[@name='btnK']/ancestor::div[@class='FPdoLc lJ9FBc']")).submit();
				
	}

	
}
