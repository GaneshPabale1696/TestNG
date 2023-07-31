package myPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableWithPagination {

	public static void main(String[] args) {
		// Launch chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops); // launch chrome

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://demo.opencart.com/admin/index.php");

		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");

		WebElement userpassword = driver.findElement(By.xpath("//input[@id='input-password']"));
		userpassword.clear();
		userpassword.sendKeys("demo");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//button[@class='btn-close']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();

		// tables
		// 1)find total number of pages in table
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(text);

		int total_pages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));

		System.out.println("Total Number of Pages:" + total_pages);

		for (int p = 1; p <= 5; p++) {

			WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("Active Page:" + active_page.getText());
			// active_page.click();

			Actions actions = new Actions(driver);
			actions.moveToElement(new WebDriverWait(driver, Duration.ofSeconds(60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='pagination']//li//span"))))
					.click().build().perform();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr"))
					.size();
			System.out.println("Number of rows:" + rows);

			// 3)Read all the rows from each page
			for (int r = 1; r <= rows; r++) {
				String OrderID = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]"))
						.getText();
				String CustomerName = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[3]"))
						.getText();
				String Status = driver
						.findElement(By.xpath(
								"//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]"))
						.getText();

				if (Status.equals("Pending")) {
					System.out.println(OrderID + " " + CustomerName + " " + Status);
				}

			}

			String pageno = Integer.toString(p + 1);
			WebElement clickpagination = driver
					.findElement(By.xpath("//ul[@class='pagitionation']//li//a[text()='" + pageno + "']"));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(clickpagination).click().perform();

		}

	}

}
