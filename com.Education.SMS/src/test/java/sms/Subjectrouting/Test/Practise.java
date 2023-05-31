package sms.Subjectrouting.Test;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;

import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class Practise
{
	private static final String ScreenShotName = null;

	public static void main(String[] args) throws Throwable
	{
		
				//Launch the browser
			WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		
		//Implicit wait
		wLib.waitTillPageGetsLoad(driver);
		
		
		//Maximize the browser
		wLib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		
		
		//fetching data from fileutility of admin
		String URL = fLib.getPropertyKeyValue("url");
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		//Enter the URL
		
		driver.get(URL);
		
		//Login as Admin with Usn and Pwd and submit
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USN, PWD);
	
		DashboardPage dashboardPage = new DashboardPage(driver);
		
		dashboardPage.clickOnstudentLink();
		dashboardPage.clickOnaddStudentLink();
		
		
		
		
		//driver.get("http://rmgtestingserver:8081/secure/Dashboard.jspa");
		
		/*
		Date date = new Date();
		String string = date.toString();
		System.out.println(string);
		
		
		/*Random random = new Random();
		
	
			int ranNum = random.nextInt(100);
			System.out.println(ranNum);
		
		
		
		
		
		/*
		WebdriverUtility wLib = new WebdriverUtility();
		wLib.takeScreenshot(driver, "Photo");
		
		/*
				TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
				File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
					LocalDateTime local = LocalDateTime.now();
				String date = local.toString().replace(" ","_").replace(":","-").replace(".","-");
				File dst = new File("./screenshots/"+date+".png");
				FileUtils.copyFile(src, dst);
				
			/*	
				
				wLib.takeScreenshot(driver, ScreenShotName);
				/*
				TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
				File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
				File dst = new File("./screenshots/b.png");
				FileUtils.copyFile(src, dst);
				/*
				
				//Implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Maximize the browser
				driver.manage().window().maximize();
				/*
				//Fetch the data from Property files
				FileInputStream fis = new FileInputStream("./src/test/resources/TestData.properties");
				Properties prop = new Properties();
				prop.load(fis);
				
				String URL = prop.getProperty("url");
				String username = prop.getProperty("USN");
				String password = prop.getProperty("PWD");
				
				
				
				
				
				//Enter the URL
				driver.get(URL);
				
				//Login as Admin with Usn and Pwd and submit
				driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(password);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				*/
				/*
				
				Workbook wb = WorkbookFactory.create(Fis);
				Sheet sh = wb.getSheet("Sheet1");
				Row row = sh.getRow(1);
				Cell cell = row.getCell(1);
				String data = cell.toString();
				
				System.out.println(data);
				// example driver.findElement(By.xpath("")).sendKeys(data);
		*/
	}

}
