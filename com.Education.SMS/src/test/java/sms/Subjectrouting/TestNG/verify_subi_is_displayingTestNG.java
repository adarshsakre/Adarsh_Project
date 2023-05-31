package sms.Subjectrouting.TestNG;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.ParentDashboardPage;
import Com.Edu.SMSObjectRepo.TeacherDashboardPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import smsGenericUtils.BaseClass;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class verify_subi_is_displayingTestNG extends BaseClass
{
	@Test(priority = 1)
	public void selectGrade() throws Throwable
	{
		//Importing file from Generic Utility
		WebdriverUtility wLib = new WebdriverUtility();
		FileUtility fLib = new FileUtility();
		
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USNT, PWDT);
		
		assertTrue(driver.getCurrentUrl().contains("dashboard2"));
		Reporter.log("teacher Dashboard Page is Displaying",true);
		
		//click on my student
		TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(driver);

		teacherDashboardPage.myStudent();
		
		//select a grade from dropdown
		TimetablePage timetablePage = new TimetablePage(driver);
		timetablePage.gradeDropdown("ok", wLib);
		
		//click on submit
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.submitButton();
		
	}
	@Test(priority = 2)
	public void verifySubject() throws Throwable
	{
		//property files
		String USNP = fLib.getPropertyKeyValue("usnp");
		String PWDP = fLib.getPropertyKeyValue("pwdp");
		
		//Login as Parent
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USNP, PWDP);
		
		assertTrue(driver.getCurrentUrl().contains("dashboard"));
		Reporter.log("Parent Dashboard Page is Displaying",true);
		//click on subject
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnsubjectLink();
		
		//click on all subjects
		ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
		parentDashboardPage.clickOnAllSubjectLink();

	}

}
