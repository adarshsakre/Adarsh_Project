package sms.Subjectrouting.TestNG;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Edu.SMSObjectRepo.AddTeacherPage;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.TeacherDashboardPage;
import Com.Edu.SMSObjectRepo.TeacherPettyCashPage;
import smsGenericUtils.BaseClass;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class PettycashTestNgTest1 extends BaseClass
{	


	ExcelUtility eLib = new ExcelUtility();
	WebdriverUtility wLib = new WebdriverUtility();

	@Test(priority = 1)
	public void createTeacher() throws Throwable
	{
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		System.out.println("Excecution Script");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USN, PWD);
		System.out.println("logged in Successfully");

		//Click on Teacher Button
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnteacherlink();
		String url = driver.getCurrentUrl();

		//verifying using Assert
		//Assert.assertEquals("http://rmgtestingserver/domain/Student_Management_System/view/dashboard.php", url);
		//Assert.assertTrue(url.contains("dashboard"), "Verify DashBoardPage");
		//Assert.assertNotEquals("Fakeurl", url);
		//Assert.assertNull(url);
		Assert.assertNotNull(url);
		Reporter.log("Dashboard page is displaying",true);

		//Click on Add teacher Link
		dashboardPage.clickOnaddTeacherLink();


		JavaUtility jLib = new JavaUtility();

		AddTeacherPage addTeacherPage = new AddTeacherPage(driver);
		addTeacherPage.indexNumberTxtFld(eLib, "Sheet1", 3, 0,jLib);

		//Enter the Full name
		addTeacherPage.fullnameTxtfld(eLib, "Sheet1", 3, 1);
		System.out.println(jLib.getRandomNumber());

		//Enter the Initials
		addTeacherPage.nameWithInitials(eLib, "Sheet1", 3, 2);

		//Enter the Address
		addTeacherPage.address(eLib, "Sheet1", 3, 3);

		//Select the Gender
		addTeacherPage.genderDropdown(wLib, "Male");

		//Enter phone number
		addTeacherPage.phoneNumber(eLib, "Sheet1", 3, 4);

		//Enter Mail id
		addTeacherPage.emailAddress(eLib, "Sheet1", 3, 5,jLib);

		//Upload photo
		addTeacherPage.fileUpload(wLib, "C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");

		//click on Submit button
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.submitButton();

		//handle the confirmation msg
		jLib.robotClass();

		//Click on Teacher Button
		dashboardPage.clickOnteacherlink();

		//Click on All teacher Link
		dashboardPage.clickOnallTeacherLink();

		//search a teacher
		common.searchTxtFld("ok");
	}
	@Test(priority = 2)
	public void addpettyCash() throws Throwable
	{
		//Fetch data of Teacher from FileUtility
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USNT, PWDT);

		//verify teacher dashboard page
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard2"));
		Reporter.log("Teacher DashBoard Page is Displaying",true);

		//click on My petty cash
		TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(driver);
		teacherDashboardPage.myPettyCashLink();


		//click on Add button
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.addButton();

		//Add description and money
		TeacherPettyCashPage teacherPettyCashPage = new TeacherPettyCashPage(driver);
		teacherPettyCashPage.discriptionTxtFld("Chalk");
		teacherPettyCashPage.amountTxtFld("500");
		teacherPettyCashPage.submitButton();

		Thread.sleep(4000);
		//Search for Petty cash
		common.searchTxtFld("2023-05-15");

	}

	@Test(priority = 3)
	public void approvePettyCash() throws Throwable 
	{
		//Login as Admin

		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USN, PWD);

		//click on petty cash
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.pettyCashLink();

		//Verify Admin Dashboard page 
		Assert.assertTrue(driver.getCurrentUrl().contains("view"));
		Reporter.log("Admin dashboard page is displaying",true);
		//Enter the details of teacher
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.searchTxtFld("ok");

		//Approve
		//		driver.findElement(By.xpath("//a[@id='aApprove_5']")).click();	
		//		driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();


	}
}
