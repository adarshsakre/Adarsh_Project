package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClassRoomPage
{
	
	//Declaration
	@FindBy(xpath = "//input[@placeholder='Enter classroom name']")private WebElement enterClassRoomTxtFld;
	
	@FindBy(xpath = "//input[@placeholder='Enter student count']")private WebElement enterStudentCountTxtFld;
	
		
	
	
	//Initialization
	public AddClassRoomPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


//Utilization
	public WebElement getEnterClassRoomTxtFld() {
		return enterClassRoomTxtFld;
	}



	public WebElement getEnterStudentCountTxtFld() {
		return enterStudentCountTxtFld;
	}

	//Methods
	
	public void enterClassRoomTxtFld(String value)
	{
		enterClassRoomTxtFld.sendKeys(value);
	}
	public void enterStudentCountTxtFld(String value)
	{
		enterStudentCountTxtFld.sendKeys(value);
	}
}
