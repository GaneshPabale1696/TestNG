package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickAction {

	public static void main(String[] args) {

		// Launch chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");

		driver.switchTo().frame("iframeResult");
		
		 WebElement dblclick=driver.findElement(By.xpath("//p[@ondblclick='myFunction()']"));
	 
		 Actions act=new Actions(driver);
		 act.doubleClick(dblclick).build().perform();
		 
		 
	}

}
