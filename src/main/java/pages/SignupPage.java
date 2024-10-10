package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethodTest;

public class SignupPage extends ProjectSpecificMethodTest {

	

	//locate all the object
	@FindBy(id="signin2")
	WebElement signupbtn1;
	

	@FindBy(id="sign-username")
	WebElement signusernamefield;
	
	@FindBy(id="sign-password")
	WebElement signpasswordfield;
	
	@FindBy(xpath="//button[text() ='Sign up']")
	WebElement signupbtnRegformfield;
		
	public SignupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//method fill the username using data provider
	public SignupPage signupUsername(String Username) {
		findElementAndSendkeys("sign-username", Username);
		return this;
		
	}
	//method fill the password using
	public SignupPage signupPassword(String password) {
		findElementAndSendkeys("sign-password", password);
		return this;
		
	}
	//method for click on button
	public SignupPage signupButton() {
		signupbtnRegformfield.click();
		return this;
	}
}
