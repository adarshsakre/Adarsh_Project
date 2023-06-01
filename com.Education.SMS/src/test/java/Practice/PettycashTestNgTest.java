package Practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Com.Edu.SMSObjectRepo.AddTeacherPage;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.TeacherDashboardPage;
import Com.Edu.SMSObjectRepo.TeacherPettyCashPage;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class PettycashTestNgTest extends BaseClass1
{	

    //june/01
	//code changed twice now

	ExcelUtility eLib = new ExcelUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	

	@Test(priority = 1)
	public void createTeacher() throws Throwable
	{
		JavaUtility jLib = new JavaUtility();
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		System.out.println("Excecution Script");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USN, PWD);
		System.out.println("logged in Successfully");

		//Click on Teacher Button
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnteacherlink();

		//Click on Add teacher Link
		dashboardPage.clickOnaddTeacherLink();

		AddTeacherPage addTeacherPage = new AddTeacherPage(driver);
		addTeacherPage.indexNumberTxtFld(eLib, "Sheet1", 3, 0,jLib);

		//Enter the Full name
		addTeacherPage.fullnameTxtfld(eLib, "Sheet1", 3, 1);

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


		Thread.sleep(4000);
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

	@Test
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

		//Enter the details of teacher
		CommonComponentsPage common = new CommonComponentsPage(driver);
		common.searchTxtFld("ok");

		//Approve
		driver.findElement(By.xpath("//a[@id='aApprove_5']")).click();	
		driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();
		

	}
}
