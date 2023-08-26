package MyPackage2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions ops=new FirefoxOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new FirefoxDriver(ops); // launch chrome
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		
		//How to capture cookies from browser
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Size of Cookies:"+cookies.size());

		
	}

}
