package base;

import utils.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class ProjectSpecificMethodTest extends Utility{

	//parameter to ensure browser and take chrome
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void browserLaunch(String brower, String url) {
		launchBrowse(brower, url);
	}

	@AfterMethod
	public void browserClose() {
		CloseBrowser();
	}
	
	//method to read data from excel
	@DataProvider(name="ReadfromExcel")
	public String[][] excelRead() throws IOException{
		String[][] data=readExcel(excelFile,sheetName);
		return data;
	}
}
   