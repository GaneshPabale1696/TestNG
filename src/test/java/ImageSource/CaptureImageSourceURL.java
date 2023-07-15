package ImageSource;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureImageSourceURL {

	static WebDriver  driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome
		Reporter.log("chrome browser opened...");

		driver.get("https://www.facebook.com/");

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		//open url
		WebElement imgLogo=driver.findElement(By.xpath("//img[@alt='Facebook']"));
		
		//capture "src" attribute of the image logo
		System.out.println("Src attribute value:  "+imgLogo.getAttribute("src"));
	
		driver.quit();
	}

}
