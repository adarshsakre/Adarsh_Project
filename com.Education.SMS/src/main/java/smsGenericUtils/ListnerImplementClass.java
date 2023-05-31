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

public class ListnerImplementClass implements ITestListener
{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	
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

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	

}
