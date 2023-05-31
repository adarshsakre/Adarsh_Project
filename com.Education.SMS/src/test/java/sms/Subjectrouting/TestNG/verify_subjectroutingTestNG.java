package sms.Subjectrouting.TestNG;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com.Edu.SMSObjectRepo.AddClassRoomPage;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.SubjectPage;
import Com.Edu.SMSObjectRepo.SubjectRoutingPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.BaseClass;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class verify_subjectroutingTestNG extends BaseClass //TC09
{
	@Test
	public void subjectRouting() throws Throwable
	{
				
				FileUtility fLib = new FileUtility();
				WebdriverUtility wLib = new WebdriverUtility();
				JavaUtility jLib = new JavaUtility();
				
				//Fetvh the property files
				String USN = fLib.getPropertyKeyValue("usn");
				String PWD = fLib.getPropertyKeyValue("pwd");
				
				//Login as Admin with Usn and Pwd and submit
				LoginPage loginPage = new LoginPage(driver);
				loginPage.loginToApp(USN, PWD);
				
				//verify the Admin Dashboard page using URL
				assertTrue(driver.getCurrentUrl().contains("dashboard"));
				Reporter.log("Admin Dashboard Page is Displaying",true);
				
				//click on the subject
				DashboardPage dashboardPage = new DashboardPage(driver);
				dashboardPage.clickOnsubjectLink();
				
				//Enter the subject Name
				SubjectPage subjectPage = new SubjectPage(driver);
				subjectPage.subjectNameTxtfld("hello");
				
				//click on submit button
				CommonComponentsPage common = new CommonComponentsPage(driver);
				common.submitButton();
				Thread.sleep(5000);
				
				//click on the classroom
				dashboardPage.clickOnClassroomLink();
				
				//add the classroom
				int randomNumber = jLib.getRandomNumber();
				AddClassRoomPage addClassRoomPage = new AddClassRoomPage(driver);
				addClassRoomPage.enterClassRoomTxtFld("ookk"+randomNumber);
				addClassRoomPage.enterStudentCountTxtFld("1"+randomNumber);
				common.submitButton();
				Thread.sleep(5000);
				
				//click on Subject routing
				dashboardPage.clickOnsubjectRoutingLink();
				
				//click on Add button
				common.addButton();
				
				//Enter the details of Grade, Subject, Teacher
				//1 Grade dropdown
				TimetablePage timetablePage = new TimetablePage(driver);
				timetablePage.gradeDropdown("ok", wLib);

				//2 Subject dropdown
				timetablePage.subjectDropdown("ok", wLib);
				
				//3 Teacher dropdown
				timetablePage.teacherDropdown("ok", wLib);
				
				//4 Enter fees
				SubjectRoutingPage subjectRoutingPage = new SubjectRoutingPage(driver);
				subjectRoutingPage.feesTxtFld("20");;
				
				//click on submit
				common.submitButton();
				Thread.sleep(4000);
	}
}