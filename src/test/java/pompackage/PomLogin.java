package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass{

// we will create first object repository
	@FindBy (css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")  //Driver.findElement(By. 
	WebElement Username;
	@FindBy (css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")
	WebElement Password;
	@FindBy (css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
	WebElement Loginbtn;
	
	
	// initiate page elements
	public PomLogin() {
		PageFactory.initElements(driver, this); //using initElements we can initialize all the webElement located at findby
		                                        // this keyword convert local into global
		
	}
	
	public void typeusername(String name) {
		
		Username.sendKeys(name);
	}
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbutton() {
		Loginbtn.click();
	}
	public String verify() {
		return driver.getTitle();
	}
}
