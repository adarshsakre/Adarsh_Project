package sms.Subjectrouing.Test.Pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.ExamTimetablePage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.SubjectRoutingPage;
import Com.Edu.SMSObjectRepo.TeacherDashboardPage;
import Com.Edu.SMSObjectRepo.TeacherPettyCashPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class Subjectrouting_Editable //TC12
{
	public static void main(String[] args) throws Throwable
	{
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Imported files from Generic utility
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		
		//Maximize
		wLib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		
		//Implicitwait
		wLib.waitTillPageGetsLoad(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Property file import
		String URL = fLib.getPropertyKeyValue("url");
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");
		
		//Login as Teacher
		driver.get(URL);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USNT, PWDT);

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
		
		Thread.sleep(4000);
		
		//Logout as Teacher
		DashboardPage dashboardPage = new DashboardPage(driver);
		
		dashboardPage.profileAndSignoutlink();
		dashboardPage.signoutLink();

		//import property files
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		
		//Login as Admin
		loginPage.loginToApp(USN, PWD);
		
		//click on subject routing
		dashboardPage.clickOnsubjectRoutingLink();
		
		//click on search field
		common.searchTxtFld("Ravi355");
		
		//click on edit button
		timetablePage.editButton();
		
		//edit the fees 
		SubjectRoutingPage subjectRoutingPage = new SubjectRoutingPage(driver);
		subjectRoutingPage.editfeesTxtFld("200");
		
		//click on update button
		timetablePage.updateButton();
		
		//logout
		dashboardPage.profileAndSignoutlink();
		dashboardPage.signoutLink();
		
		
		
	}

}
