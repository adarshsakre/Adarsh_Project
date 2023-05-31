package sms.Subjectrouing.Test.Pom;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Com.Edu.SMSObjectRepo.AddTeacherPage;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.TeacherDashboardPage;
import Com.Edu.SMSObjectRepo.TeacherPettyCashPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class Petty_cash_generic 
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
		
		//verify the Admin Dashboard page using URL
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("dashboard")){
			System.out.println("Dashboard page is Displayed");
			
		}
		else 
		{
			System.out.println("Dashboard page is not Displayed");
		}
		//Click on Teacher Button
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.clickOnteacherlink();
		//driver.findElement(By.xpath("//span[.='Teacher']")).click();
		
		//Click on Add teacher Link
		dashboardPage.clickOnaddTeacherLink();
		//driver.findElement(By.xpath("//a[.=' Add Teacher']")).click();
		
				//Enter the Index number from excel
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
		
		//signOut as Admin
		dashboardPage.profileAndSignoutlink();
		dashboardPage.signoutLink();
		
		//Fetch data of Teacher from FileUtility
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");
		
		//Login as Teacher
		driver.get(URL);
		loginPage.loginToApp(USNT, PWDT);
		
		//click on My petty cash
		TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(driver);
		teacherDashboardPage.myPettyCashLink();
		
		//click on Add button
		common.addButton();
		
		//Add description and money
		TeacherPettyCashPage teacherPettyCashPage = new TeacherPettyCashPage(driver);
		teacherPettyCashPage.discriptionTxtFld("Chalk");
		teacherPettyCashPage.amountTxtFld("500");
		teacherPettyCashPage.submitButton();
	
		Thread.sleep(4000);
		//Search for Petty cash
		common.searchTxtFld("2023-05-15");
		
		//signout as teacher
		dashboardPage.profileAndSignoutlink();
		dashboardPage.signoutLink();
		
		//Login as Admin
		loginPage.loginToApp(USN, PWD);
		
		//click on petty cash
		dashboardPage.pettyCashLink();
		
		//Enter the details of teacher
		common.searchTxtFld("ok");
		
		//Approve
		driver.findElement(By.xpath("//a[@id='aApprove_5']")).click();	
		driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();
		//logout
		dashboardPage.logout();
	}}