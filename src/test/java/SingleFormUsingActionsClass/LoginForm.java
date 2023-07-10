package SingleFormUsingActionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginForm {

	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();

		//open url
		driver.get("https://www.saucedemo.com/");
		
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		
//		//click on login button 
//		driver.findElement(By.id("login-button")).click();

		Actions actions=new Actions(driver);
		Action seriesofaction=actions.moveToElement(driver.findElement(By.id("user-name")))
				.click()
				.sendKeys("standard_user",Keys.TAB)
				.sendKeys("secret_sauce",Keys.ENTER).build();
		seriesofaction.perform();
		
	}

}
