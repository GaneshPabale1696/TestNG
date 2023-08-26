package MyPackage2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
	    WebDriverManager.chromedriver().setup();
		ChromeOptions ops=new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
	    WebDriver driver = new ChromeDriver(ops); // launch chrome
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		//Drawing border and take screnshot 
		/*WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptUtil.drawBorder(logo, driver);
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".\\Screenshots\\logo.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Getting title of the page
		/*String title=JavascriptUtil.getTitleByJS(driver);
		System.out.println(title);*/
		
		//Click Action
		//WebElement regLink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		//JavascriptUtil.clickElementByJS(regLink, driver);
		
		//Generate Alert
		//JavascriptUtil.generateAlert(driver, "This is my alert....");
		
		//Refreshing the page
		//JavascriptUtil.refreshBrowserByJS(driver);
		
		//Scrolling down page
		//JavascriptUtil.ScrollPageDown(driver);
		
		/*
		 * try { Thread.sleep(4000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 */		
		
		//Scroll up page
		//JavascriptUtil.ScrollPageUp(driver);
		
		//Zoom Page
		//JavascriptUtil.zoomPageByJS(driver);
		
		//change background color
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptUtil.flash(logo, driver);
		
	}

}
