package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

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

		driver.get("https://www.redbus.in/");

		driver.manage().window().maximize();
		
		String year="2023";
		String month="Sep";
		String date="10";
		
		driver.findElement(By.xpath("//div[@id='onwardCal']")).click();//open the date picker
		
		while(true) {
			
			//driver.findElement(By.xpath("//body//section[@id='rh_main']//div[@id='onwardCal']//div//div//div//div//div[1]//div[2]")).getText();
			
			//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/ancestor::div[@id='onwardCal']
			
			String monthyear =driver.findElement(By.xpath("//body//section[@id='rh_main']//div[@id='onwardCal']//div//div//div//div//div[1]//div[2]")).getText();
			System.out.println(monthyear);
			
			
			String arr[]=monthyear.split(" ");
			String mon=arr[0];
			System.out.println(mon);
			String yr=arr[1];
			System.out.println(yr);
			
			
			if(mon.equalsIgnoreCase(month))
			{
				break;
			} else
			{
				driver.findElement(By.xpath("//body//section[@id='rh_main']//div[@id='onwardCal']//div//div//div//div//div[1]//div[3]")).click();
			}
			
		}
		
		
	}

}
