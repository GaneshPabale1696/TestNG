package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest2 {

	static LoginPageUsingPageFactory lpg; 
	
	public static void main(String[] args) {	
			
		WebDriverManager.chromedriver().setup();	
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		lpg=new LoginPageUsingPageFactory(driver);
		lpg.enterUsername("standard_user");
		lpg.enterUserPassword("secret_sauce");
		lpg.clickOnLoginBtn();
		
	}

}
