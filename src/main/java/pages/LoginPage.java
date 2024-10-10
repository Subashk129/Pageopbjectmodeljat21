package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethodTest;

public class LoginPage extends ProjectSpecificMethodTest{

	@FindBy(xpath="//button[@onclick=\"logIn()\"]")
	WebElement login;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	//method loginusername
	public LoginPage loginuserName(String username) {
		findElementAndSendkeys("loginusername", username);
		return this;
	}
	//method password
	public LoginPage loginpassword(String password) {
		findElementAndSendkeys("loginpassword", password);
		return this;
	}
	//method click action
	public LoginPage logInButton() {
		login.click();
		return this;
	}
}
