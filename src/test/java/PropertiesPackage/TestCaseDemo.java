package PropertiesPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseDemo {

	static WebDriver driver; 
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome
		Reporter.log("chrome browser opened...");
		
		//open URL
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		ReadConfigFiles configFile=new ReadConfigFiles();	
		driver.get(configFile.getURL());
		Reporter.log("URL is opened...");
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(configFile.getUserName());		
				
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(configFile.getPassword());
	
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
