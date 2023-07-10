package EncodePasswordDemo;

import java.time.Duration;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EncodePasswordExample {

	public static void main(String[] args) {
		
		//encode password
//		String password = "admin123";
//		
//		byte[] encodedPassword=Base64.encodeBase64(password.getBytes());
//		
//		System.out.println(new String(encodedPassword));

		//Launch chrome browser
		WebDriverManager.chromedriver().setup();	
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//enter username
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		//decode password
		byte[] decodePassword=Base64.decodeBase64("YWRtaW4xMjM=");

		//enter password
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(new String(decodePassword));
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

}
