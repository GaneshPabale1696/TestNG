package MyPackage2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShots {

	public static void main(String[] args) throws IOException {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://demo.nopcommerce.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		//Full Page Screenshot
		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File trg=new File(".\\screenshots\\homepage.png");
//		FileUtils.copyFile(src, trg);
		
		//Screenshot of section/portion of the page
		
		/*WebElement section=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src=section.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\featuredoroduct.png");
		FileUtils.copyFile(src, trg);*/
		
		
		WebElement ele=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src=ele.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, trg);
		
		
		//driver.close();
			
	}

}
