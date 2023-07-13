package myPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkDropDownSorted {

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

		driver.get("https://www.twoplugs.com/");

		driver.findElement(By.xpath("//a[normalize-space()='Live Posting']")).click();
		
		WebElement drpElement=driver.findElement(By.xpath("//select[@name='category_id']"));
		Select drpselect=new Select(drpElement);
		
		List<WebElement> options=drpselect.getOptions();
		
		ArrayList orignalList=new ArrayList();
		ArrayList templist=new ArrayList();
		
		for(WebElement option:options)
		{
			orignalList.add(option.getText()); 
			templist.add(option.getText());
		}
		
		System.out.println("Original List:"+ orignalList);
		System.out.println("Temp List:"+ templist);
		
		Collections.sort(templist); //sorting
		
		System.out.println("Original List After Sorting:"+ orignalList);
		System.out.println("Temp List After Sorting:"+ templist);
		
			if(orignalList.equals(templist)) {
				System.out.println("Dropdown Sorted...");
			} else
			{
				System.out.println("Dropdown Unsorted..");
			}
			
			driver.close();
	}

}
