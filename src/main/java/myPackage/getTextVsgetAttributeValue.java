package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttributeValue {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// Launch chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://demo.nopcommerce.com/login");
		
		WebElement emailinputbox=driver.findElement(By.id("Email"));
		
		//emailinputbox.clear();
		emailinputbox.sendKeys("pabaleganesh42@gmail.com");
		
		//capturing text from inputform
		System.out.println("Result from getAttribute() method:"+emailinputbox.getAttribute("value"));
		
		System.out.println("Result from getText() method:" + emailinputbox.getText());
		
		//login button
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
		
		System.out.println(button.getAttribute("type"));
		System.out.println(button.getAttribute("class"));
		
		System.out.println(button.getText());
		
		String title=driver.findElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']")).getText();
		
		System.out.println(title);	
	}

}
