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
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		
		//How to capture cookies from browser
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Size of Cookies:"+cookies.size());

		//How to print cookies from browser?  
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName()+" "+cookie.getValue());
		}
		
		//How to add Cookie to the browser?
		Cookie cookieobj=new Cookie("MyCookie123","123456");
		driver.manage().addCookie(cookieobj);
		
		cookies=driver.manage().getCookies();
		System.out.println("Size of Cookies after adding:"+ cookies.size());//6
		
		
		//How to delete specific Cookie from the browser?
		//driver.manage().deleteCookie(cookieobj);
		driver.manage().deleteCookieNamed("MyCookie123");
		cookies=driver.manage().getCookies();
		System.out.println("Size of Cookies after deleting:"+ cookies.size());//5
		
		//how to delete all the cookies from the browser?
		driver.manage().deleteAllCookies();
		System.out.println("Size of Cookies after deleting all cookies:"+ cookies.size());//0
		
		driver.quit();
		
	}

}
