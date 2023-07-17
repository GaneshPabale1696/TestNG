package myPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		// driver.findElement(By.linkText("Today's Deals")).click();

		// driver.findElement(By.partialLinkText("Deals")).click();//pass some portion
		// of value

		// How to capture all the links

		List<WebElement> links = driver.findElements(By.tagName("a"));
		//System.out.println("Number of links present:" + links.size());
		
		/*for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
		}*/
		
		for(WebElement link:links)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
			
		}
		
	}

}
