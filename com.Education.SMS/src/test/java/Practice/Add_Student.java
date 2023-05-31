package Practice;

import org.openqa.selenium.chrome.ChromeDriver;
import Com.Edu.SMSObjectRepo.AddStudentDetailsHashmapPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.ExcelUtils;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class Add_Student 
{

	public static void main(String[] args) throws Throwable 
	{
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//Import generic files
		WebdriverUtility wLib = new WebdriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();

		wLib.waitTillPageGetsLoad(driver);
		wLib.maximizeWindow(driver);

		//fetch property files
		String URL = fLib.getPropertyKeyValue("url");
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");

		//Login as Admin
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USN, PWD);
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnteacherlink();
		dashboardPage.clickOnaddTeacherLink();
		
		ExcelUtils eu = new ExcelUtils();
		AddStudentDetailsHashmapPage add = new AddStudentDetailsHashmapPage();
		add.addStudent(eu.getMultipledate("Add_Student"), driver);
		
		
	}
	
}