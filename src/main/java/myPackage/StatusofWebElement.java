package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofWebElement {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get("https://demo.nopcommerce.com/register ");
		
		//isDisplayed() isEnabled()
		
		WebElement searchStore=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		
		System.out.println("Displayed Status:"+ searchStore.isDisplayed());
		
		System.out.println("Displayed Status:" +searchStore.isEnabled());
		
		//isSelected()
		 WebElement maleradiobutton= driver.findElement(By.xpath("//input[@id='gender-male']"));
		 WebElement femaleradiobutton= driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		 System.out.println("Redio button is: "+maleradiobutton.isSelected());
		 System.out.println("Redio button is: "+femaleradiobutton.isSelected());
		 
		 maleradiobutton.click();
		 
		 System.out.println("Male button is: "+maleradiobutton.isSelected());
		 
		 femaleradiobutton.click();
		 
		 System.out.println("Female button is: "+femaleradiobutton.isSelected());
		 
		 
	}

}
