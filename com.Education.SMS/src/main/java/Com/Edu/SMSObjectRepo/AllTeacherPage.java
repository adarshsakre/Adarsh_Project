package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtils.ExcelUtility;

public class AllTeacherPage 
{
	@FindBy(xpath = "//input[@type='search']")private WebElement searchTeacherTxtFld;
	
	
	
	
	
	//Initiliazation
	public AllTeacherPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}




	public WebElement getSearchTeacherTxtFld() {
		return searchTeacherTxtFld;
	}
	
	//methods
	public void searchTeacherTxtFld(String text)
	{
		searchTeacherTxtFld.sendKeys(text);
	}

}
