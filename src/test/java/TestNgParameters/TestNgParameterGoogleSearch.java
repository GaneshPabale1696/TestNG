package TestNgParameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgParameterGoogleSearch {

	WebDriver driver;
	
	@Parameters({"keyword"})
	@Test
	public void googleSearch(String searchdata) throws InterruptedException {
		
		// Launch chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://www.google.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		WebElement search=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		search.sendKeys(searchdata);
		Thread.sleep(3000);
		
		Assert.assertEquals(searchdata,search.getAttribute("value"));
		
		driver.quit();
	}

}
