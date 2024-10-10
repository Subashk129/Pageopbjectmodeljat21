package pageobjectmodeljat21;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethodTest;
import pages.HomePage;

public class TC001_LoginTest extends  ProjectSpecificMethodTest {
	
	@BeforeTest
	public void fileSetup() {
		excelFile="TestData";
		sheetName="LoginTest";
	}
	
	@Test(dataProvider = "ReadfromExcel")
	public void LoginTest(String Username, String Password, String dataMatch) throws InterruptedException {
		
		HomePage obj=new HomePage(driver);
		obj.loginHomeButton()
		.loginuserName(Username)
		.loginpassword(Password)
		.logInButton();
		
		
		//validate testcases for login functionality
		if(dataMatch.equals("bothcorrect")) {
			Thread.sleep(2000);
			WebElement name=driver.findElement(By.id("nameofuser"));
			System.out.println(name.getText());
			AssertJUnit.assertTrue(name.isDisplayed());
		
		}else if(dataMatch.equals("wrongpassword")) {
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			alert.accept();
			AssertJUnit.assertEquals(text, "Wrong password");
			
		}else if(dataMatch.equals("wrongusername")) {
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			alert.accept();
			AssertJUnit.assertEquals(text, "User does not exist.");
			
		}else {
			Thread.sleep(2000);
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			alert.accept();
			AssertJUnit.assertEquals(text, "User does not exist.");
		}
    }
}
	
	

