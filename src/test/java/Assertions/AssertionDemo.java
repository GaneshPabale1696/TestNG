package Assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionDemo {
	
	@Test
	public void testMethod()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		//SoftAssert softVerify=new SoftAssert();
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("Verify title.....");
		String expectedTitle="Automation Testing Practice1";
		String actualTitle=driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle,"Title Verifying");
		
		System.out.println("verifying presence of wikipedia-icon");
		WebElement icon= driver.findElement(By.className("wikipedia-icon"));
		Assert.assertTrue(icon.isDisplayed());
		
		System.out.println("verifying presence of wikipedia button");
		WebElement searchButton= driver.findElement(By.className("wikipedia-search-button"));
		Assert.assertTrue(searchButton.isDisplayed());
		
		driver.close();
	}

}
