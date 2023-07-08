package myPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
				
				//Launch chrome driver
				WebDriverManager.chromedriver().setup();
				ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(ops); // launch chrome
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
				
				driver.get("https://www.nopcommerce.com/");
				
				System.out.println("Title of the web page is:" + driver.getTitle());
				
				System.out.println("CurrentURL is: "+ driver.getCurrentUrl());
				
				System.out.println(driver.getPageSource());
				
				
				
	}

}

