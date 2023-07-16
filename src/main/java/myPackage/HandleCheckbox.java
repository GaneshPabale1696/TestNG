package myPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {

	static WebDriver driver;
	
	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://itera-qa.azurewebsites.net/home/automation");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		//1) Select specific checkbox
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//2)select all the check boxes 
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
		
		System.out.println("Total no. of check boxes:" +checkboxes.size());

		/*
		 * for(WebElement checkbox:checkboxes) { checkbox.click(); }
		 * 
		 * for(int i=0;i<checkboxes.size();i++) { checkboxes.get(i).click(); }
		 */	
		
		//3) select multiple check boxes by choice
		
		/*
		 * for(WebElement chbox:checkboxes) {
		 * 
		 * String checkboxname=chbox.getAttribute("id");
		 * 
		 * if(checkboxname.equals("monday") || checkboxname.equals("sunday")) {
		 * chbox.click(); 
		 * 		}
		 *  }
		 */
		
		//4)Select Last 2 check boxes
		
		
		  int totalcheckboxes=checkboxes.size();
		 /* 
		 * for(int i=totalcheckboxes-3;i<totalcheckboxes;i++) {
		 * checkboxes.get(i).click(); }
		 */
		
		//5) Select first 2 check boxes
		
		for(int i=0;i<totalcheckboxes;i++) {
			
			if(i<=2) {
			  checkboxes.get(i).click(); 
			}
		}
			
	}

}
