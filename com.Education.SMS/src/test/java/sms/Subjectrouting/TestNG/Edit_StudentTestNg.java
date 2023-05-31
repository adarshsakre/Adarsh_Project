package sms.Subjectrouting.TestNG;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Com.Edu.SMSObjectRepo.AddStudentDetails;
import Com.Edu.SMSObjectRepo.CommonComponentsPage;
import Com.Edu.SMSObjectRepo.DashboardPage;
import Com.Edu.SMSObjectRepo.LoginPage;
import Com.Edu.SMSObjectRepo.TimetablePage;
import smsGenericUtils.BaseClass;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class Edit_StudentTestNg extends BaseClass //TC_14
{
	
	@Test
	public void addStudentDetails() throws Throwable
	{
			//Imported from Generic package
				ExcelUtility eLib = new ExcelUtility();
				FileUtility fLib = new FileUtility();
				WebdriverUtility wLib = new WebdriverUtility();
			
				//Fetch from Property files
				String USN = fLib.getPropertyKeyValue("usn");
				String PWD = fLib.getPropertyKeyValue("pwd");
				
				//Login as Admin
				LoginPage loginPage = new LoginPage(driver);
				loginPage.loginToApp(USN, PWD);
				
				Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Verify DashboardPage");
				Reporter.log("Admin Dashboard page is displaying",true);
		
				//click on student
				DashboardPage dashboardPage = new DashboardPage(driver);
				dashboardPage.clickOnstudentLink();
				
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
				
				//skip wait
				JavaUtility jLib = new JavaUtility();
				jLib.robotClass();
				
	}

}
