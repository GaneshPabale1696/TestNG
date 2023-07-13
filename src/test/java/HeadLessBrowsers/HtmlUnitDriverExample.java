package HeadLessBrowsers;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverExample {

	public static void main(String[] args) {
		// Launch chrome driver
		HtmlUnitDriver driver = new HtmlUnitDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.google.com/");

		System.out.println("Before Search title:" + driver.getTitle());

		// print title of web page
		WebElement searchBox = driver.findElement(By.name("q"));

		// enter search keyword
		searchBox.sendKeys("India Gate");
		searchBox.sendKeys(Keys.ENTER);

		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("After Search title:" + driver.getTitle());

		driver.quit();

	}

}
