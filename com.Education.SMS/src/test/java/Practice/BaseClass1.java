package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class BaseClass1
{
	
	
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebdriverUtility wLib=new WebdriverUtility();
	public WebDriver driver;
	//Connect to DB
	@BeforeSuite
	public void config_BS()
	{
		System.out.println("Connect to DB");
	}
	
	//launch the browser
	@BeforeClass
	public void config_BC()
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 wLib.maximizeWindow(driver);
		System.out.println("Launch the browser");
		wLib.waitTillPageGetsLoad(driver);
	}
	
	
	//Login to App
	@BeforeMethod
	public void config_BM() throws Throwable
	{
		String URL = fLib.getPropertyKeyValue("url");
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		driver.get(URL);
		
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.loginToApp(USN, PWD);
//		System.out.println("logged in Successfully");
		
	}
	
	
	//Logout
	@AfterMethod
	public void config_AM()
	{
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.logout();
		System.out.println("Logged out from app");
	}
	
	
	//close the browser
	@AfterClass
	public void config_AC()
	{
		driver.quit();
		System.out.println();
	}

	
	
	//close the DB
	@AfterSuite
	public void config_AS()
	{
		System.out.println("Disconnect to DB");
	}

}
