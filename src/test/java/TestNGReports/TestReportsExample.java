package TestNGReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestReportsExample {
	
	public WebDriver driver;
	
	@Test
	public void googleSearch() {
		
	WebDriverManager.chromedriver().setup();
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(ops); // launch chrome
	Reporter.log("chrome browser opened...");
	
	
	driver.get("https://www.google.com/");
	Reporter.log("URL is opened...");
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	WebElement Search=driver.findElement(By.name("q"));
	
	Search.sendKeys("Qutub Minar");
	Reporter.log("Qutub Minar keyword is entered...");
	
	Search.sendKeys(Keys.ENTER);
	Reporter.log("keyword is pressed..");
	
	}
	
	
}
