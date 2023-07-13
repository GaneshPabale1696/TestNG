package HeadLessBrowsers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxHeadlessBrowser {

	static WebDriver driver;
	
	public static void main(String[] args) {

		// Launch chrome driver
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions ops = new FirefoxOptions();
		ops.addArguments("-headless");
		driver = new FirefoxDriver(ops); // launch chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.google.com/");
		
		System.out.println("Before Search title:"+ driver.getTitle());
		
		//print title of web page
		WebElement searchBox=driver.findElement(By.name("q"));
		
		//enter search keyword
		searchBox.sendKeys("India Gate");
		searchBox.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("After Search title:"+ driver.getTitle());
		
		driver.quit();
		
	}


}
