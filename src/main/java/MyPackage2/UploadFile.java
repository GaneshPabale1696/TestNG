package MyPackage2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions ops = new ChromeOptions(); 
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://www.foundit.in/seeker/registration");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		//driver.findElement(By.xpath("//div[@class='uploadResume']")).click();
		
		//using sendkeys
		//driver.findElement(By.xpath("//input[@type='file']")).sendKeys("F:\\ganesh\\Resume-cv.pdf");
		
		//Using Robot class methods
		WebElement button= driver.findElement(By.xpath("//div[@class='uploadResume']"));
		button.click();
		
		//1)Copy the Path
		//2)CTRL + V
		//3)Enter
		
		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rb.delay(2000);
		
		//put path to file in a clipboard
		StringSelection ss=new StringSelection("F:\\ganesh\\Resume-cv.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//CTRL+V
		rb.keyPress(KeyEvent.VK_CONTROL); //Press on Control key
		rb.keyPress(KeyEvent.VK_V); //Press Control key
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		//Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER); 
		
	}

}
