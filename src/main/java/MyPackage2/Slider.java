package MyPackage2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		WebElement min_slider=driver.findElement(By.xpath("//span[1]"));

		System.out.println("Location of the min slider:"+min_slider.getLocation());
		System.out.println("Height and Width of the element:"+min_slider.getSize());
		
		Actions act=new Actions(driver);
		act.dragAndDropBy(min_slider, 125, 0).perform();
		
		System.out.println("Location of the min slider:"+min_slider.getLocation());
		System.out.println("Height and Width of the element:"+min_slider.getSize());
		
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		act.dragAndDropBy(max_slider, -100, 0).perform();
		
		
		
	}

}
