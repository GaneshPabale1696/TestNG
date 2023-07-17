package myPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow {

	static WebDriver driver;

	public static void main(String[] args) {

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		// getWindowHandle()
		//String windowID = driver.getWindowHandle();// return ID of the single browser window
		//System.out.println(windowID);//C80C2EAD1DB489E7B604FA67A6B23B26
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();//opens another browser window
		
		// getWindowHandles()
		Set<String> windowIds=driver.getWindowHandles();//return ID's of multiple browser window
		
		//First Method 1)-Iterator()
		//Iterator<String> itr=windowIds.iterator();
		
		//String parentWindoID=itr.next();
		//String childWindowID=itr.next();
		
		//System.out.println("Parent window ID: "+parentWindoID );
		//System.out.println("Child window ID: "+childWindowID );
		
		//2nd method-List/ArrayList
		List<String> windowIDsList=new ArrayList(windowIds);//converting Set -->List
		
		/*String parentWindowIDs=windowIDsList.get(0);//parent window ID
		String childWindowIDs=windowIDsList.get(1);//child window id
		
		System.out.println("Parent window ID: "+parentWindowIDs );
		System.out.println("Child window ID: "+childWindowIDs );
		
		
		//How to use window ID's for switching
		driver.switchTo().window(parentWindowIDs);
		System.out.println("Parent Window Title:"+driver.getTitle());
		
		driver.switchTo().window(childWindowIDs);
		System.out.println("Child Window Title:"+driver.getTitle()); */
		
		//For each loop
		
		/*for(String windID:windowIDsList)
		{
			//System.out.println(windID);
			String title=driver.switchTo().window(windID).getTitle();
			System.out.println(title);
		}*/
		
		//driver.close();//close single browser window driver which pointing
		//driver.quit();//close all browser windows		
		
		for(String windID:windowIDsList)
		{
			String title=driver.switchTo().window(windID).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
			{
				driver.close();
			}
		}
		
	}

}
