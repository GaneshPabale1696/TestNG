package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGWizaardDemo {
	
  @Test
  public void f() {
  
	//Launch chrome driver
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(ops); // launch chrome
			
			//open url
			driver.get("https://www.google.com/");
			
			String expectedTitle="Google";
			
			String actualTitle = driver.getTitle();
			
			Assert.assertEquals(actualTitle, expectedTitle);
			
			driver.quit();	
	  
  }
}
