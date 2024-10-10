package pageobjectmodeljat21;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethodTest;
import pages.HomePage;
import pages.SignupPage;

public class TC002_SignupTest extends ProjectSpecificMethodTest{

	@BeforeTest
	public void fileSetup() {
		excelFile="TestData";
		sheetName="SignupTest";
	}
	
	@Test(dataProvider = "ReadfromExcel")
	public void SignupTest(String Username, String Password, String DataMatch) throws InterruptedException {
		
		HomePage obj=new HomePage(driver);
		obj.signupHomeButton()
		.signupUsername(Username)
		.signupPassword(Password)
		.signupButton();
		
	//validate the testcases using assertion
		if(DataMatch.equals("newUser")) {
			//perform some opration
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			AssertJUnit.assertEquals(text, "Sign up successful.");
		}else if(DataMatch.equals("ExistingUser")) {
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			AssertJUnit.assertEquals(text, "This user already exist.");
		
		}else if(DataMatch.equals("InvalidUserName")) {
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			AssertJUnit.assertEquals(text, "Please fill out Username and Password..");
		}else {
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			String text = driver.switchTo().alert().getText();
			alert.accept();
			AssertJUnit.assertEquals(text, "Please fill out Username and Password..");
		}
		
			
	}
	
}  
