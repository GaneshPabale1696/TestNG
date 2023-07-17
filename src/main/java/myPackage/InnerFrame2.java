package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InnerFrame2 {

	static WebDriver driver;
	
	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		//iframe[@title='Iframe Example']
		//iframe[@id='iframeResult']
		
		driver.switchTo().frame("iframeResult");//switch to outer frame
		driver.switchTo().frame(0); //switch to inner iframe
		
		System.out.println("Text Present Inner Frame:"+ driver.findElement(By.xpath("//h1")).getText());
		
		driver.switchTo().parentFrame();//go to parent frame/outer frame
		
		String text=driver.findElement(By.xpath("//p[contains(text(),'You can use the height and width attributes to specify the size of the iframe:')]")).getText();
		
		System.out.println("Text Present in outer frame: " + text);
		
	}

}
