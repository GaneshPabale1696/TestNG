package myPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	static WebDriver driver;
	
	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		/*//Alert window with OK button
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Alert']")).click(); try {
		 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } driver.switchTo().alert().accept();
		 */
		
		//Alert window with OK and Cancel button
		/*
		 * driver.findElement(By.
		 * xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		 * 
		 * try { Thread.sleep(3000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 * 
		 * //driver.switchTo().alert().accept();//Close alert by using OK button
		 * driver.switchTo().alert().dismiss();//close alert by using cancel button
		 */
		
		//Alert window with input box, capture text from alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alertwindow=driver.switchTo().alert();
		 System.out.println("The message displayed on alert: "+ alertwindow.getText());
		
		 alertwindow.sendKeys("Welcome");
		 alertwindow.accept();
		 
	}

}
