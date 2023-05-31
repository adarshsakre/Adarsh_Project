package Com.Edu.SMSObjectRepo;

import org.apache.xmlbeans.impl.xpath.XPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubjectPage 
{
	//Declaration
	@FindBy(xpath = "//input[@placeholder='Enter Subject name']")private WebElement subjectNameTxtfld;
	
	//Initialization
	
	public SubjectPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization

	public WebElement getSubjectNameTxtfld() {
		return subjectNameTxtfld;
	}
	
	//methods
	public void subjectNameTxtfld(String text) 
	{
		subjectNameTxtfld.sendKeys(text);
	}
	
	
	
	
}
