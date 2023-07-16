package myPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestedDropDown_BingSearch {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://www.bing.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("selenium");
		
		List<WebElement> list=driver.findElements(By.xpath("//li[@class='sa_sg as_extra_pad']//span"));

		System.out.println("Size of Auto Suggestions: "+list.size());
		
		for(WebElement listItem :list) {
			
			if(listItem.getText().contains("download"))
				{
					listItem.click();
					break;
				}
			
		}
		
	}

}
