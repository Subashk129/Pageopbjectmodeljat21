package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethodTest;

public class HomePage extends ProjectSpecificMethodTest {

	//locate the objects
	@FindBy(id="signin2")
	WebElement signup;
	
	@FindBy(id="login2")
	WebElement login;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//method signup and click on button
	public SignupPage signupHomeButton() {
		signup.click();
		return new SignupPage(driver);
		
	}
	//method login and click on button
	public LoginPage loginHomeButton() {
		login.click();
		return new LoginPage(driver);
	}
}
