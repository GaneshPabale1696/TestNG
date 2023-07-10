package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Using page factory
public class LoginPageUsingPageFactory {
	
	WebDriver driver;
	
	LoginPageUsingPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//identify web elements
	//identify user name
	@FindBy(id="user-name") 
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	
	public void enterUsername(String uname) {
		username.sendKeys(uname);
	}
	
	public void enterUserPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginBtn() {
		loginbtn.click();
	}
	

}
