package MyPackage2;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWordFile {

	public static void main(String[] args) {
		
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		
		//Chrome driver
		/*HashMap<String, String> preferences=new HashMap<String, String>();
		preferences.put("download.default_directory", location);
		
		ChromeOptions ops=new ChromeOptions();
		ops.setExperimentalOption("prefs", preferences);
		ops.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(ops); // launch chrome*/
		
		
		//Edge Browser
		
		/*
		 * HashMap<String, String> preferences=new HashMap<String, String>();
		 * preferences.put("download.default_directory", location);
		 * 
		 * EdgeOptions ops=new EdgeOptions(); ops.setExperimentalOption("prefs",
		 * preferences); ops.addArguments("--remote-allow-origins=*");
		 * 
		 * WebDriverManager.edgedriver().setup(); WebDriver driver = new
		 * EdgeDriver(ops);
		 */
		
		//Firefox drive
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword"); //Mine
		profile.setPreference("browser.download.folderList",2);//0-desktop 1-download 2-desired location
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions ops=new FirefoxOptions();
		ops.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(ops);
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.close();
		
	}

}
