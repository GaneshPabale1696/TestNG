package myPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_DropDown {

	public static void main(String[] args) {

		// Launch chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ops.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();

		Select monthdrp=new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		monthdrp.selectByVisibleText("Sep"); 
		
		Select year=new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		year.selectByVisibleText("1996"); 
	
		String date="16";
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
	
		for(WebElement ele:allDates)
		{
			String dt=ele.getText();
			
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		
		}
	}

}
