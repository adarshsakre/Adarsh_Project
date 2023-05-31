package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage 
{
	//Declaration
	@FindBy(xpath = "//span[.='Classroom']")private WebElement classroomLink;

	@FindBy(xpath = "//span[.='Grade']")private WebElement gradeLink;

	@FindBy(xpath = "//span[.='Subject']")private WebElement subjectLink;

	@FindBy(xpath = "//span[.='Teacher']")private WebElement teacherlink;
	@FindBy(xpath = "//a[.=' Add Teacher']")private WebElement addTeacherLink;
	@FindBy(xpath = "//a[.=' All Teacher']")private WebElement allTeacherLink;

	@FindBy(xpath = "//span[.='Subject Routing']")private WebElement subjectRoutingLink;

	@FindBy(xpath = "//span[.='Timetable']")private WebElement timetableLink;

	@FindBy(xpath = "//span[.='Student']")private WebElement studentLink;
	@FindBy(xpath = "//a[.=' Add Student']")private WebElement addStudentLink;
	@FindBy(xpath = "//a[.=' All Student']")private WebElement allStudentLink;
	@FindBy(xpath = "//a[.=' Leave Student']")private WebElement leaveStudentLink;


	@FindBy(xpath = "//span[.='Student Payment']")private WebElement studentPaymentLink;

	@FindBy(xpath = "//span[.='Attendance']")private WebElement attendanceLink;
	@FindBy(xpath = "//a[.=' Add Attendance']")private WebElement addAttendanceLink;
	@FindBy(xpath = "//a[.='Student Attendance History ']")private WebElement studentAttendanceHistoryLink;
	@FindBy(xpath = "//a[.=' Teacher Attendance History']")private WebElement teacherAttendanceHistoryLink;

	@FindBy(xpath = "//span[.='Exam']")private WebElement examLink;
	@FindBy(xpath = "//a[.='Create Exam']")private WebElement createExamLink;
	@FindBy(xpath = "//a[.=' Exam Timetable']")private WebElement examTimetableLink;
	@FindBy(xpath = "//a[.='Student Exam Marks']")private WebElement studentExamMarksLink;
	@FindBy(xpath = "//a[.='Student Exam Marks History']")private WebElement studentExamMarksHistoryLink;

	@FindBy(xpath = "//span[.='Petty Cash']")private WebElement pettyCashLink;

	@FindBy(xpath = "//img[@class='user-image']")private WebElement profileAndSignoutlink;
	@FindBy(xpath = "//a[.='Sign out']")private WebElement signoutLink;
	//Initialization
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getClassroomLink() {
		return classroomLink;
	}
	public WebElement getGradeLink() {
		return gradeLink;
	}
	public WebElement getSubjectLink() {
		return subjectLink;
	}
	public WebElement getTeacherlink() {
		return teacherlink;
	}
	public WebElement getAddTeacherLink() {
		return addTeacherLink;
	}
	public WebElement getAllTeacherLink() {
		return allTeacherLink;
	}
	public WebElement getSubjectRoutingLink() {
		return subjectRoutingLink;
	}
	public WebElement getTimetableLink() {
		return timetableLink;
	}
	public WebElement getStudentLink() {
		return studentLink;
	}
	public WebElement getAddStudentLink() {
		return addStudentLink;
	}
	public WebElement getAllStudentLink() {
		return allStudentLink;
	}
	public WebElement getLeaveStudentLink() {
		return leaveStudentLink;
	}
	public WebElement getStudentPaymentLink() {
		return studentPaymentLink;
	}
	public WebElement getAttendanceLink() {
		return attendanceLink;
	}
	public WebElement getAddAttendanceLink() {
		return addAttendanceLink;
	}
	public WebElement getStudentAttendanceHistoryLink() {
		return studentAttendanceHistoryLink;
	}
	public WebElement getTeacherAttendanceHistoryLink() {
		return teacherAttendanceHistoryLink;
	}
	public WebElement getExamLink() {
		return examLink;
	}
	public WebElement getCreateExamLink() {
		return createExamLink;
	}
	public WebElement getExamTimetableLink() {
		return examTimetableLink;
	}
	public WebElement getStudentExamMarksLink() {
		return studentExamMarksLink;
	}
	public WebElement getStudentExamMarksHistoryLink() {
		return studentExamMarksHistoryLink;
	}
	public WebElement getPettyCashLink() {
		return pettyCashLink;
	}
	public WebElement getProfileAndSignoutlink() {
		return profileAndSignoutlink;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}

	//Create a method to perform click action

	//click on classroom link
	public void clickOnClassroomLink()
	{
		classroomLink.click();
	}

	//click on Grade Link
	public void clickOnGradeLink()
	{
		gradeLink.click();
	}

	//click on subjectLink
	public void clickOnsubjectLink()
	{
		subjectLink.click();
	}


	//click on teacher link
	public void clickOnteacherlink()
	{
		teacherlink.click();
	}


	//click on addTeacher Link
	public void clickOnaddTeacherLink()
	{
		addTeacherLink.click();
	}


	//click on allTeacher Link
	public void clickOnallTeacherLink()
	{
		allTeacherLink.click();
	}


	//click on subjectRoutingLink
	public void clickOnsubjectRoutingLink()
	{
		subjectRoutingLink.click();
	}


	//click on timetableLink
	public void clickOntimetableLink()
	{
		timetableLink.click();
	}


	//click on studentLink
	public void clickOnstudentLink()
	{
		studentLink.click();
	}


	//click on addStudentLink
	public void clickOnaddStudentLink()
	{
		addStudentLink.click();
	}


	//click on allStudentLink
	public void allStudentLink()
	{
		allStudentLink.click();
	}


	//click on Grade Link
	public void leaveStudentLink()
	{
		leaveStudentLink.click();
	}


	//click on studentPaymentLink
	public void studentPaymentLink()
	{
		studentPaymentLink.click();
	}

	//click on attendanceLink
	public void attendanceLink()
	{
		attendanceLink.click();
	}

	//click on addAttendanceLink
	public void addAttendanceLink()
	{
		addAttendanceLink.click();
	}

	//click on studentAttendanceHistoryLink
	public void studentAttendanceHistoryLink()
	{
		studentAttendanceHistoryLink.click();
	}

	//click on teacherAttendanceHistoryLink
	public void teacherAttendanceHistoryLink()
	{
		teacherAttendanceHistoryLink.click();
	}

	//click on examLink
	public void examLink()
	{
		examLink.click();
	}

	//click on Grade Link
	public void createExamLink()
	{
		createExamLink.click();
	}

	//click on examTimetableLink
	public void examTimetableLink()
	{
		examTimetableLink.click();
	}

	//click on studentExamMarksLink
	public void studentExamMarksLink()
	{
		studentExamMarksLink.click();
	}

	//click on studentExamMarksHistoryLink
	public void studentExamMarksHistoryLink()
	{
		studentExamMarksHistoryLink.click();
	}

	//click on Grade Link
	public void pettyCashLink()
	{
		pettyCashLink.click();
	}

	//click on profileAndSignoutlink
	public void profileAndSignoutlink()
	{
		profileAndSignoutlink.click();
	}

	//click on signout Link
	public void signoutLink()
	{
		signoutLink.click();
	}
	public void logout()
	{
		profileAndSignoutlink.click();
		signoutLink.click();
	}

}
