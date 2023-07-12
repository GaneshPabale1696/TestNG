package myPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsElements {

	static WebDriver driver;
	
	public static void main(String[] args) {
	
		//Launch chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60 ));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.get("https://demo.nopcommerce.com/");
		
		//findElement()-->Return the Single WebElement
		//Scenario=1
//		WebElement serachbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
//		serachbox.sendKeys("XYZ");

		//Scenario=2
//		WebElement ele=driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
//		System.out.println(ele.getText());
		
		//3
		//WebElement searchButton=driver.findElement(By.xpath("//button[normalize-space()='login']"));
		
		
		//findelements()--->Returns multiple web element 
		
	    //1
//		List<WebElement> links=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
//		System.out.println("Number of elements captured:" + links.size());
//		
//		for(WebElement ele:links)
//		{
//			System.out.println(ele.getText());
//		}
		
		//2
		//List<WebElement> logo=driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
		//System.out.println(logo.size());
		
		//
		List<WebElement> elements=driver.findElements(By.xpath("//img[contains(title,'Electronics')]"));
		System.out.println(elements.size());
		
	}

}
