package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	//functionality to get the report
	public static ExtentReports getreport() {
		//provid path to capture .html report
		String path="C:\\Users\\Admin\\eclipse-workspace\\pageobjectmodeljat21\\E Reports\\index.html";
		//create a physical report
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		//provide title of the report
		reporter.config().setReportName("Ecommerce-Automation Framework ");
		
		
		//add automation to physical report
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
