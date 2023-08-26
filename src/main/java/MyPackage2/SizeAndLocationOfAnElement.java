package MyPackage2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfAnElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		
		//Location -method 1
		System.out.println("Location(x,y):"+logo.getLocation());
		System.out.println("Location(x):"+logo.getLocation().getX());
		System.out.println("Location(y):"+logo.getLocation().getY());
		
		//Location -method 2
		System.out.println("Location(x):"+logo.getRect().getX());
		System.out.println("Location(y):"+logo.getRect().getY());
		
		//Size-method1
		 System.out.println("Size(Width,Height)"+logo.getSize());
		 System.out.println("Size(Height)"+logo.getSize().getHeight());
		 System.out.println("Size(Width)"+logo.getSize().getWidth());
		 
		 //Size - Method 2
		 System.out.println("Size(Height)"+logo.getRect().getDimension().getHeight());
		 System.out.println("Size(Width)"+logo.getRect().getDimension().getWidth());

		 driver.close();
	}

}
