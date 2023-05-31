package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtils.WebdriverUtility;

public class ExamTimetablePage 
{
	@FindBy(xpath = "//select[@id='grade']")private WebElement gradeDrpodown;
	
	@FindBy(xpath = "//select[@id='exam']")private WebElement examDropdown;
	
	@FindBy(xpath = "//button[.='Next']")private WebElement nextButton;
	
	
	
	//initilization
	public ExamTimetablePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}



	public WebElement getGradeDrpodown() {
		return gradeDrpodown;
	}



	public WebElement getExamDropdown() {
		return examDropdown;
	}



	public WebElement getNextButton() {
		return nextButton;
	}

	//methods
	public void gradeDrpodown(WebdriverUtility wLib,String grade)
	{
		wLib.selectElementInDropdown(grade, gradeDrpodown);
		
	}
	
	public void examDropdown(WebdriverUtility wLib, String exam)
	{
		wLib.selectElementInDropdown(exam, examDropdown);
	}
	public void nextButton() 
	{
		nextButton.click();
		
	}
}
