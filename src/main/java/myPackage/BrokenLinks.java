package myPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.poi.sl.draw.geom.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	static WebDriver driver;

	public static void main(String[] args) throws IOException{

		// Launch chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome

		driver.get("http://www.deadlinkcity.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		int brokenlinks=0;
		
		for(WebElement element:links)
		{
			String url=element.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("Url is empty");
				continue;
			}
			
			URL link = null;
			try {
				link = new URI(url).toURL();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				
				HttpURLConnection httpcon=(HttpURLConnection) link.openConnection();
				httpcon.connect();
				if(httpcon.getResponseCode()>=400)
				{
					System.out.println(httpcon.getResponseCode()+"is"+"   Broken link");
					brokenlinks++;
				} else
				{
					System.out.println(httpcon.getResponseCode() + "is "+"Valid Link");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			} 
			
		}
		
		System.out.println("Number of broken links:" + brokenlinks);
		driver.quit();
	}

}
