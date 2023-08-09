package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtils.WebdriverUtility;

public class TimetablePage 
{
	@FindBy(xpath = "//select[@id='grade']")private WebElement gradeDropdown;
	
	@FindBy(xpath = "//select[@id='day']")private WebElement dayDropdown;
	
	@FindBy(xpath = "//select[@id='subject']")private WebElement subjectDropdown;
	
	@FindBy(xpath = "//select[@id='teacher']")private WebElement teacherDropdown;
	
	@FindBy(xpath = "//select[@id='classroom']")private WebElement classroomDropdown;
	
	@FindBy(xpath = "//input[@id='start_time']")private WebElement startTimetxtfld;
	
	@FindBy(xpath = "//input[@id='end_time']")private WebElement endTimetxtfld;
	
	@FindBy(xpath = "//button[@class='btn btn-info ']")private WebElement submitBtnInAddExam;
	
	@FindBy(xpath = "//a[.='Edit']")private WebElement editButton;
		
	@FindBy(xpath = "//a[.='Delete']")private WebElement deleteButton;
	
	@FindBy(xpath = "//select[@id='day1']")private WebElement editDayDropdown;
	
	@FindBy(xpath = "//select[@id='subject1']")private WebElement editSubjectDropdown;
	
	@FindBy(xpath = "//select[@id='grade1']")private WebElement editGradeDropdown;
	
	@FindBy(xpath = "//select[@id='classroom1']")private WebElement editClassroomDropdown;
	
	@FindBy(xpath = "//input[@id='start_time1']")private WebElement editStartTimeTxtfld;
	
	@FindBy(xpath = "//input[@id='end_time1']")private WebElement editEndTimetexfld;
	
	@FindBy(xpath = "//button[@id='btnSubmit1']")private WebElement updateButton;
	
	@FindBy(xpath = "//div[@class='panel-heading']//button[@class='close']")private WebElement closeButton;
	
	
	
	//Initialization
	
		public TimetablePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getGradeDropdown() {
			return gradeDropdown;
		}

		public WebElement getDayDropdown() {
			return dayDropdown;
		}

		public WebElement getSubjectDropdown() {
			return subjectDropdown;
		}

		public WebElement getTeacherDropdown() {
			return teacherDropdown;
		}

		public WebElement getClassroomDropdown() {
			return classroomDropdown;
		}

		public WebElement getStartTimetxtfld() {
			return startTimetxtfld;
		}

		public WebElement getEndTimetxtfld() {
			return endTimetxtfld;
		}
		
		public WebElement getSubmitBtnInAddExam() {
			return submitBtnInAddExam;
		}

		public WebElement getEditButton() {
			return editButton;
		}

		public WebElement getDeleteButton() {
			return deleteButton;
		}

		
		

		public WebElement getCloseButton() {
			return closeButton;
		}

		public WebElement getEditDayDropdown() {
			return editDayDropdown;
		}

		public WebElement getEditSubjectDropdown() {
			return editSubjectDropdown;
		}

		public WebElement getEditGradeDropdown() {
			return editGradeDropdown;
		}

		public WebElement getEditClassroomDropdown() {
			return editClassroomDropdown;
		}

		public WebElement getEditStartTimeTxtfld() {
			return editStartTimeTxtfld;
		}

		public WebElement getEditEndTimetexfld() {
			return editEndTimetexfld;
		}

		public WebElement getUpdateButton() {
			return updateButton;
		}

		//click on gradedropdown
		public void gradeDropdown(String grade, WebdriverUtility wLib )
		{	
			wLib.selectElementInDropdown(grade, gradeDropdown);
		}
	
		//day dropdown
		public void dayDropdown(String day,WebdriverUtility wLib)
		{
			wLib.selectElementInDropdown(day, dayDropdown);
		}
		
	
		//Subject dropdown
		public void subjectDropdown(String subject,WebdriverUtility wLib)
		{
			wLib.selectElementInDropdown(subject, subjectDropdown);
		}
		
		
		//Teacher dropdown
		public void teacherDropdown(String teacher,WebdriverUtility wLib)
		{
			wLib.selectElementInDropdown(teacher, teacherDropdown);
		}
		//verification method
		public String verifyTeacher()
		{
			String text = teacherDropdown.getText();
			return text;
		}
		
		//classroomdropdown
		public void classroomDropdown(String classroom,WebdriverUtility wLib)
		{
			wLib.selectElementInDropdown(classroom, classroomDropdown);
		}
		
		//startTime
		public void startTimetxtfld(String StartTime)
		{
			startTimetxtfld.sendKeys(StartTime);;
		}
		
		//EndTime
		public void endTimetxtfld(String endTime)
		{
			endTimetxtfld.sendKeys(endTime);;
		}
		
		//click on submit
		public void submitBtnInAddExam()
		{
			submitBtnInAddExam.click();
		}
		
		//Editbutton
		public void editButton()
		{
			editButton.click();
		}
		
		//click on delete button
		public void deleteButton()
		{
			deleteButton.click();
		}
		
		//close button
		public void closeButton()
		{
			closeButton.click();
		}
		//edit day drop down
		public void editDayDropdown(WebdriverUtility wLib,String editDay) 
		{
			wLib.selectElementInDropdown(editDayDropdown,editDay);
		}
		
		public void editSubjectDropdown(WebdriverUtility wLib,String editSub) 
		{
			wLib.selectElementInDropdown(editSubjectDropdown,editSub);
		}
		
		public void editGradeDropdown(WebdriverUtility wLib,String editGrade) 
		{
			wLib.selectElementInDropdown(editGradeDropdown,editGrade);
		}
		
		public void editClassroomDropdown(WebdriverUtility wLib,String editClass) 
		{
			wLib.selectElementInDropdown(editClassroomDropdown,editClass);
		}
		public void editStartTimeTxtfld(String editStartTime) 
		{
			editStartTimeTxtfld.sendKeys(editStartTime);
		}
		public void editEndTimetexfld(String editEndTime) 
		{
			editEndTimetexfld.sendKeys(editEndTime);
		}
		public void updateButton()
		{
			
			updateButton.click();
		}
		
}
