package sms.Subjectrouing.Test.Pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Com.Edu.SMSObjectRepo.AddTeacherPage;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class Add_Subjectrouting //TC_25
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
		JavaUtility jLib = new JavaUtility();

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

		//click on teacher button
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnteacherlink();

		//click on Add teacher
		dashboardPage.clickOnaddTeacherLink();

		//Enter the Index number
		AddTeacherPage addTeacherPage = new AddTeacherPage(driver);
		addTeacherPage.indexNumberTxtFld(eLib, "Sheet1", 3, 8,jLib);
		
		//Enter the Full name
		addTeacherPage.fullnameTxtfld(eLib, "Sheet1", 3, 9);

		//Enter the Initials
		addTeacherPage.nameWithInitials(eLib, "Sheet1", 3, 10);

		//Enter the Address
		addTeacherPage.address(eLib, "Sheet1", 3, 11);

		//Select the Gender
		addTeacherPage.genderDropdown(wLib, "Male");

		//Enter phone number
		addTeacherPage.phoneNumber(eLib, "Sheet1", 3, 12);

		//Enter Mail id
		addTeacherPage.emailAddress(eLib, "Sheet1", 3, 13,jLib);

		//Upload photo
		addTeacherPage.fileUpload(wLib, "C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");
		
		//click on submit
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.submitButton();
		
		Thread.sleep(4000);
		
		//click on time table
		dashboardPage.clickOntimetableLink();

		//select grade from dropdown
		TimetablePage timetablePage = new TimetablePage(driver);
		timetablePage.gradeDropdown("ok", wLib);

		//click on Submit
		common.submitButton();
		
		

		//click on Add
		common.addButton();

		//select subject from drop down
		timetablePage.subjectDropdown("ok", wLib);
		
		//select teacher from drop down
		timetablePage.teacherDropdown("ok", wLib);
		String v = timetablePage.verifyTeacher();
		if (v.contains("ok")) 
		{
			System.out.println("Teacher is Displaying");
		}
		else
		{
			System.out.println("Kanta Ella");
		}

		driver.get(URL);
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals(URL))
		{
			System.out.println("Login page is displaying");
			
		}
		
	}
}