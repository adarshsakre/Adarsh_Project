package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherDashboardPage 
{
	@FindBy(xpath = "//a[@href='my_petty_cash.php']")private WebElement myPettyCashLink;
	
	@FindBy(xpath = "//span[.='Exam']")private WebElement examLink;
	
	@FindBy(xpath = "//a[.='Exam Timetable']")private WebElement examTimetableLink;
	
	@FindBy(xpath = "//span[.='My Student']")private WebElement myStudent;

	

	public WebElement getMyStudent() {
		return myStudent;
	}


	//Initialization
	public TeacherDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getMyPettyCashLink() {
		return myPettyCashLink;
	}

	public WebElement getExamLink() {
		return examLink;
	}
	
	public WebElement getExamTimetableLink() {
		return examTimetableLink;
	}


	//method
	public void myPettyCashLink()
	{
		myPettyCashLink.click();
	}
	public void examLink()
	{
		examLink.click();
	}
	public void examTimetableLink() 
	{
		examTimetableLink.click();
	}
	public void myStudent()
	{
		myStudent.click();
	}
	
}
