package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtils.WebdriverUtility;



public class SubjectRoutingPage 
{
	@FindBy(xpath = "//input[@id='fee']")private WebElement feesTxtFld;
	
	@FindBy(xpath = "//select[@id='teacher1']")private WebElement editTeacherDropdown;
	
	@FindBy(xpath = "//input[@id='fee1']")private WebElement editfeesTxtFld;
	
	//initilization
	
	public SubjectRoutingPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getEditTeacherDropdown() {
		return editTeacherDropdown;
	}

	public WebElement getEditfeesTxtFld() {
		return editfeesTxtFld;
	}
	
	public WebElement getFeesTxtFld() {
		return feesTxtFld;
	}

	//Methods
	public void editTeacherDropdown(WebdriverUtility wLib,String editTeacher)
	{
		wLib.selectElementInDropdown(editTeacher, editTeacherDropdown);
	}
	
	public void editfeesTxtFld(String text)
		{
			editfeesTxtFld.sendKeys(text);
		}
	
	public void feesTxtFld(String text)
	{
		feesTxtFld.sendKeys(text);
	}

}
