package sms.Subjectrouing.Test.Pom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.ParentDashboardPage;
import Com.Edu.SMSObjectRepo.TeacherDashboardPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class verify_subi_is_displaying 
{
	public static void main(String[] args) throws Throwable
	{
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Importing file from Generic Utility
		WebdriverUtility wLib = new WebdriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		wLib.maximizeWindow(driver);
		
		wLib.waitTillPageGetsLoad(driver);
		
		String URL = fLib.getPropertyKeyValue("url");
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");
		
		//Login to application as Teacher
		driver.get(URL);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USNT, PWDT);
		
		//Verify Dashboard page is displaying
		String url = driver.getCurrentUrl();
		if (url.contains("dashboard2"))
		{
			System.out.println("Teacher Dashboard page is displaying");
			
		}
		else
		{
			System.out.println("Dashboard page is not displaying");
			
		}
		
		//click on my student
		TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(driver);
		teacherDashboardPage.myStudent();
		
		//select a grade from dropdown
		TimetablePage timetablePage = new TimetablePage(driver);
		timetablePage.gradeDropdown("ok", wLib);
		
		//click on submit
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.submitButton();
		
		//logout as Teacher
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.profileAndSignoutlink();
		dashboardPage.signoutLink();
		
		//property files
		String USNP = fLib.getPropertyKeyValue("usnp");
		String PWDP = fLib.getPropertyKeyValue("pwdp");
		
		//Login as Parent
		driver.get(URL);
		loginPage.loginToApp(USNP, PWDP);
		
		//click on subject
		dashboardPage.clickOnsubjectLink();
		
		//click on all subjects
		ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
		parentDashboardPage.clickOnAllSubjectLink();

		//logout as Parent
		dashboardPage.profileAndSignoutlink();
		dashboardPage.signoutLink();
		
	}

}
