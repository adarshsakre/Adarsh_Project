package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Adarsh
 *
 */
public class LoginPage 
{
	
	//Declaration
	
	@FindBy(xpath = "//input[@placeholder='Enter email address']") private WebElement adminEmailTxtfld;
	
	@FindBy(xpath = "//input[@placeholder='Enter password']") private WebElement adminPasswordTxtFld;
	
	@FindBy(xpath = "//button[@type='submit']")private WebElement Submitbtnclick;
	
	
	
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization provide getters and setters and business libraries
	
	public WebElement getEmailTxtfld() 
	{
		return adminEmailTxtfld;
	}

	public WebElement getPasswordTxtFld() 
	{
		return adminPasswordTxtFld;
	}

	public WebElement getSubmitbtnclick()
	{
		return Submitbtnclick;
	}
	
	
	//Create a method for login
	public void loginToApp(String adminemail, String adminpassword)
	{
		adminEmailTxtfld.sendKeys(adminemail);
		adminPasswordTxtFld.sendKeys(adminpassword);
		Submitbtnclick.click();
	}
	
	
}
