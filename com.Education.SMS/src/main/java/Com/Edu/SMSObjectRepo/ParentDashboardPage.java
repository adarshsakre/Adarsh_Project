package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentDashboardPage 
{

	@FindBy(xpath = "//a[.=' All Subject']")private WebElement clickOnAllSubjectLink;
	
	
	//Initilization
	public ParentDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getClickOnAllSubjectLink() {
		return clickOnAllSubjectLink;
	}

	//methods
	public void clickOnAllSubjectLink()
	{
		clickOnAllSubjectLink.click();
	}
}
