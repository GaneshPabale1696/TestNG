package MyPackage2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionMultipleKeys {

	public static void main(String[] args) {
		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://text-compare.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		WebElement input1=driver.findElement(By.xpath("//textarea[@placeholder='Paste one version of a text here.']"));
		
		WebElement input2=driver.findElement(By.xpath("//textarea[@placeholder='Paste another version of the text here.']"));
		
		input1.sendKeys("welcome to selenium");
		
		Actions act=new Actions(driver);
		//CTRL+A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//CTRL+C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//TAB- shift to input2 box
		act.sendKeys(Keys.TAB);
		act.perform();
		
		//CTRL + V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		if(input1.getAttribute("value").equals(input2.getAttribute("value")))
		{
			System.out.println("Text copied");
		} else
		{
			System.out.println("Text is not copied");
		}
	}

}
