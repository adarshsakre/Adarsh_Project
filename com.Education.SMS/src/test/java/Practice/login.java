package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class login
{
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
				dashboardPage.logout();
		
	}

}
