package runTestNg;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Com.Edu.SMSObjectRepo.AddTeacherPage;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import smsGenericUtils.BaseClass;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;
public class Add_SubjectroutingTestNg extends BaseClass //TC_25
{
	@Test
	public void addteacher() throws Throwable, IOException
	{
		//Import generic files
		WebdriverUtility wLib = new WebdriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();

		//fetch property files
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USN, PWD);
		
		//Verify Admin Dashboard page
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		Reporter.log("Admin dashboard page is displaying",true);
		
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
		
		//Teacher present Verify
		softAssert.assertTrue(v.contains("ok"));
		Reporter.log("Teacher is Displaying",true);
//		if (v.contains("ok")) 
//		{
//			System.out.println("Teacher is Displaying");
//		}
//		else
//		{
//			System.out.println("Kanta Ella");
//		}
		timetablePage.closeButton();
 
		
		
		softAssert.assertAll();//It will throw the exception but Softassert will not stop the execution
	}	
}