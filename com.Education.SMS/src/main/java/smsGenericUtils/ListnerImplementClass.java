package smsGenericUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementClass implements ITestListener
{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		 test = report.createTest(testname);
		Reporter.log(testname+"-----> TestScript executoion Started");
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		String testname = result.getMethod().getMethodName();
		test.log(Status.PASS, testname+"-----> Passed");
	
	}

	public void onTestFailure(ITestResult result)
	{
		String textName = result.getMethod().getMethodName();
		System.out.println("----I am listening----");
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)BaseClass.sdriver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		LocalDateTime local = LocalDateTime.now();
		String cDate = local.toString().replace(" ", "_").replace(":", "_");
		File dst = new File("screenshots/"+" "+textName+" "+cDate+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		String testname = result.getMethod().getMethodName();
		test.log(Status.SKIP, testname+"-> testscript execution skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context)
	{
		//1. create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Ujetix_Project");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("com.ujetix_report");
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Base_URL", "https://localhost.com:8088");
		report.setSystemInfo("reporterName", "Tilak(Tose who executed)");
		
	}

	public void onFinish(ITestContext context) 
	{
		report.flush();
		
	}
	

}
