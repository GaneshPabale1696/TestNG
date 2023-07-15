package ExtentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGExample {

	public WebDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome
		Reporter.log("chrome browser opened...");

		driver.get("https://www.google.com/");

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void GoogleSearch() {
		WebElement Search = driver.findElement(By.name("q"));

		Search.sendKeys("Qutub Minar");
		Reporter.log("Qutub Minar keyword is entered...");

		Search.sendKeys(Keys.ENTER);
	}

	@Test
	public void VerifyLogo()
	{
		System.out.println("Verify the logo..");
		Assert.assertTrue(false);
	}
	

	@Test
	public void VerifyTitle()
	{
		System.out.println("Verify the title..");
		Assert.assertTrue(false);
		Reporter.log("Verify the title..");
	}
	

	@Test
	public void VerifyEmail()
	{
		System.out.println("Verify the Email..");
		Reporter.log("Verify the EmailID..");
		throw new SkipException("skipping this test case with exception");
	}
	
	@Test
	public void VerifyUserName()
	{
		System.out.println("Verify the UserName..");
		Assert.assertTrue(true);
		Reporter.log("Verify the UserName..");
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
