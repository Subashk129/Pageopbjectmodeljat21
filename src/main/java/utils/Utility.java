package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	//driver instance
	public static WebDriver driver;

	//instance for excel
	public String excelFile;

	//instance for sheet
	public String sheetName; 

	//method to launch browser and load url  
	public void launchBrowse(String browser, String url) {
		if(browser.equals("chrome")){
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			driver=new FirefoxDriver();
		}else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//Close browser
	public void CloseBrowser() {	 
		driver.close();
	}

	//click operation
	public void click(WebElement ele) {
		ele.click();
	}
	//find and element and send keys together
	public void findElementAndSendkeys(String attributevalue, String value) {
		driver.findElement(By.id(attributevalue)).sendKeys(value);
	}
	//Explicit wait
	public void visiblityofElement(WebElement element, int sec) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//method for reading data from excel
	public String[][] readExcel(String excelfile, String sheetname) throws IOException{
		XSSFWorkbook book = new XSSFWorkbook(
				"C:\\Users\\Admin\\eclipse-workspace\\pageobjectmodeljat21\\Data\\"+excelfile+".xlsx");
		XSSFSheet sheet=book.getSheet(sheetname);

		//get the row and column count
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();

		//2d array to store roe and column values of cell
		String[][] data=new String[rowcount][columncount];

		//get into rows
		for(int i=1;i<=rowcount;i++) {
			XSSFRow row=sheet.getRow(i);
			//get into columns
			for(int j=0;j<columncount;j++) {
				//get over cells
				XSSFCell cell=row.getCell(j);
				//cell values
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		//close the book
		book.close();
		return data;

	}
	
	//generate random username for signup
	public String randomNameGenerator() {
		//create 
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//create an object of string builder 
		StringBuilder sb= new StringBuilder();
		//create random class obj
		Random random=new Random();
		
		int length=8;
		
		for(int i=0; i<length; i++) {
			//generate random index number
		int index=random.nextInt(alphabet.length());
		// get char based on the above index
		char randomChar=alphabet.charAt(index);
		sb.append(randomChar);  
		}
		String name=sb.toString();
		System.out.println("The Random string is "+name);
		
		return name;
		
	}

	//method capturing screenshot
	public String takeScreenshot(String screenshotName) throws IOException {
		Date dt=new Date();
		String date=dt.toString();
		System.out.println(date);
		// logic
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date( ));
		//String path="C:\\Users\\Admin\\eclipse-workspace\\pageobjectmodeljat21\\ScreenShots\\"+screenshotName+"_"+time+".png";
		String path= System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName+"_"+time+".png";
		File des=new File(path);
		FileUtils.copyFile(src, des);
		return path;
	}
}
