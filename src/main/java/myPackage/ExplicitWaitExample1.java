package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample1 {

	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
				
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(Keys.ENTER);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='WebDriver']")));	
		element.click();
		
		
	}

}
