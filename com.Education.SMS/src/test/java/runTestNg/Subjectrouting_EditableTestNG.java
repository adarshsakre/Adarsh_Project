package runTestNg;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.Test;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.ExamTimetablePage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.SubjectRoutingPage;
import Com.Edu.SMSObjectRepo.TeacherDashboardPage;
import Com.Edu.SMSObjectRepo.TeacherPettyCashPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import smsGenericUtils.BaseClass;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class Subjectrouting_EditableTestNG extends BaseClass //TC12
{

	@Test(priority = 1)
	public void addTimetable() throws Throwable
	{
		//Imported files from Generic utility
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();

		//Property file import
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USNT, PWDT);
		
		//verify
		assertTrue(driver.getCurrentUrl().contains("dashboard"));
		Reporter.log("Teacher Dashboard Page is Displaying",true);
		
		//click on my petty cash
		TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(driver);
		teacherDashboardPage.myPettyCashLink();

		//click on add button
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.addButton();

		//Enter the details
		TeacherPettyCashPage teacherPettyCashPage = new TeacherPettyCashPage(driver);
		teacherPettyCashPage.discriptionTxtFld("b");
		teacherPettyCashPage.amountTxtFld("100");
		teacherPettyCashPage.submitButton();

		//Confirmation msg is displayed so to wait for 4 sec used delay
		Thread.sleep(4000);

		//click on Exam 
		teacherDashboardPage.examLink();

		//click on Exam time table
		teacherDashboardPage.examTimetableLink();

		//Enter the details of exam time table
		//select grade from dropdown
		ExamTimetablePage examTimetablePage = new ExamTimetablePage(driver);
		examTimetablePage.gradeDrpodown(wLib, "ok");

		//select exam
		examTimetablePage.examDropdown(wLib, "ok");

		//click on next button
		examTimetablePage.nextButton();

		//click on Add button
		common.addButton();

		//Add subject routing
		//Day dropdown
		TimetablePage timetablePage = new TimetablePage(driver);
		timetablePage.dayDropdown("Monday", wLib);

		//Subject Dropdown
		timetablePage.subjectDropdown("ok", wLib);

		//classroom
		timetablePage.classroomDropdown("ok", wLib);

		//Start time
		timetablePage.startTimetxtfld("10");

		//End time
		timetablePage.endTimetxtfld("11");

		//click on Submit button
		timetablePage.submitBtnInAddExam();
		
		JavaUtility jLib = new JavaUtility();
		jLib.robotClass();
		
	}
	@Test(priority = 2)
	public void editFees() throws Throwable
	{
		//import property files
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");

		//Login as Admin
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USN, PWD);
		
		assertTrue(driver.getCurrentUrl().contains("dashboard"));
		Reporter.log("Admin Dashboard page is displaying",true);

		//click on subject routing
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnsubjectRoutingLink();

		//click on search field
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.searchTxtFld("Ravi355");

		//click on edit button
		TimetablePage timetablePage = new TimetablePage(driver);
		timetablePage.editButton();

		//edit the fees 
		SubjectRoutingPage subjectRoutingPage = new SubjectRoutingPage(driver);
		subjectRoutingPage.editfeesTxtFld("200");

		//click on update button
		timetablePage.updateButton();
		Thread.sleep(4000);
	}

}
