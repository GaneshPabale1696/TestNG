package myPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

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

		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement drpCountryele=driver.findElement(By.id("//select[@id='input-country']"));
		
		Select drpCountry=new Select(drpCountryele);
		//drpCountry.selectByVisibleText("China");
		
		//drpCountry.selectByValue("10"); //Argentina
		//drpCountry.selectByIndex(12); //Australia
		
		//selecting option from dropdown without using methods
		List<WebElement> alloptions=drpCountry.getOptions();
		
		for(WebElement option:alloptions)
		{
			if(option.getText().equals("Cuba"))
			{
				option.click();
				break;
			}
		}
		 

	}

}
