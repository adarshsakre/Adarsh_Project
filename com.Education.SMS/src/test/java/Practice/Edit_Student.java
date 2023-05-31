package Practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Com.Edu.SMSObjectRepo.AddStudentDetails;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class Edit_Student //TC_14
{
	public static void main(String[] args) throws Throwable
	{
		
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
			
				//Imported from Generic package
				ExcelUtility eLib = new ExcelUtility();
				FileUtility fLib = new FileUtility();
				WebdriverUtility wLib = new WebdriverUtility();
				
				//Implicit wait
				wLib.waitTillPageGetsLoad(driver);
				
				//Maximixze the browser
				wLib.maximizeWindow(driver);
			
				//Fetch from Property files
				String URL = fLib.getPropertyKeyValue("url");
				String USN = fLib.getPropertyKeyValue("usn");
				String PWD = fLib.getPropertyKeyValue("pwd");
				
				//Login as Admin
				driver.get(URL);
				LoginPage loginPage = new LoginPage(driver);
				loginPage.loginToApp(USN, PWD);
		
				//click on student
				DashboardPage dashboardPage = new DashboardPage(driver);
				dashboardPage.clickOnstudentLink();
				String url = driver.getCurrentUrl();
				if (url.contains("dashboard")) 
				{
					System.out.println("dashboard page is displaying");
					
				}
				//click on Add student
				dashboardPage.clickOnaddStudentLink();
				
				//Enter all the Details
				//Index number
				AddStudentDetails addStudentDetails = new AddStudentDetails(driver);
				addStudentDetails.indexNumberTxtFld(eLib, "Student", 2, 0);
				
				 //Full name
				addStudentDetails.fullNameTxtFld(eLib, "Student", 2, 1);
				
				//Initial name
				addStudentDetails.initialNameTxtFld(eLib, "Student", 2, 2);
				
			  //Address
				addStudentDetails.addressTxtFld(eLib, "Student", 2, 3);
				
				//Email
				addStudentDetails.emailTxtFld(eLib, "Student", 2, 4);
				
				//Phone number
				addStudentDetails.phoneNumberTxtFld(eLib, "Student", 2, 5);
				
				 //DOB
				addStudentDetails.dateOfBirthTxtFld(eLib, "Student", 2, 6);
				
				//Gender dropdown
				addStudentDetails.genderDropdown(wLib, "Male");
				
			  //Upload photo
				addStudentDetails.filepload(wLib, "C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");
				
				//Enter Guardian details
				//Full name
				addStudentDetails.guardianFullNameTxtFld(eLib, "Guardian", 2, 0);
				
				//Initial name
				addStudentDetails.guardianInitialTxtFld(eLib, "Guardian", 2, 1);
				
				//Address
				addStudentDetails.guardianAddress(eLib, "Guardian", 2, 2);
				
				//Email
				addStudentDetails.guardianEmailTxtfld(eLib, "Guardian", 2, 3);
				
				//phone number
				addStudentDetails.guardianPhoneTxtFld(eLib, "Guardian", 2, 4);
				
				//Dob
				addStudentDetails.guardianDOB(eLib, "Guardian", 2, 5);
				
				//Gender
				addStudentDetails.guardianGenderDropdown(wLib, "Male");
				
				//Fileupload
				addStudentDetails.guardianFileUpload(wLib, "C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");
				
				//Click on next button
				addStudentDetails.nextButton();
				
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ESCAPE);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(4000);
				
				//click on student link
				dashboardPage.clickOnstudentLink();
				
				//click on all student link
				dashboardPage.allStudentLink();
				
				//select grade form dropdown
				TimetablePage timetablePage = new TimetablePage(driver);
				timetablePage.gradeDropdown("ok", wLib);
			
				//click on submit
				CommonComponentsPage common = new CommonComponentsPage(driver);
				common.submitButton();
				
				//click on edit
				timetablePage.editButton();
				
				//click on update
				common.updateButton();
				
	}

}
