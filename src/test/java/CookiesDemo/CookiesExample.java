package CookiesDemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesExample {

	public static void main(String[] args) {
		
		//launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		
		//capture all the cookies
		Set <Cookie> cookielist=driver.manage().getCookies();
		
		//print size/number of cookies
		 System.out.println("Before adding Size: "+cookielist.size());
		 
		 for(Cookie ck:cookielist) {
			 
			 System.out.println(ck.getName()+":"+ck.getValue());
		 }
		 
		 //get specific cookie according to name 
		// System.out.println(driver.manage().getCookieNamed("i18n-prefs"));
		 
		 //Create cookie
		 Cookie cookieObje=new Cookie("TestCookie","www.amazon.in");
		 
		 //add cookie to browser 
		 driver.manage().addCookie(cookieObje);
		 
		 //capture all the cookies
		  cookielist=driver.manage().getCookies();
			
			//print size/number of cookies
			 System.out.println("\n\nAfter adding Size: "+ cookielist.size());
			 
			 for(Cookie ck:cookielist) {
				 
				 System.out.println(ck.getName()+":"+ck.getValue());
			 }
		 
			 //delete cookie
			 //driver.manage().deleteCookie(cookieObje);
			  // driver.manage().deleteCookieNamed("TestCookie");
			  driver.manage().deleteAllCookies();
			 
			//capture all the cookies
			  cookielist=driver.manage().getCookies();
				
				
			   
				//print size/number of cookies
				 System.out.println("\n\nAfter deleting Size: "+ cookielist.size());
				 
				 for(Cookie ck:cookielist) {
					 
					 System.out.println(ck.getName()+":"+ck.getValue());
				 } 	 
		 driver.quit();		
	}

}
