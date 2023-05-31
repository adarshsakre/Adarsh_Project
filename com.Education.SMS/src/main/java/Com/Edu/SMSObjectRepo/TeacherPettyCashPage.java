package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherPettyCashPage
{
	//Declaration
	
	@FindBy(xpath = "//input[@placeholder='Description 1']")private WebElement discriptionTxtFld;
	
	@FindBy(xpath = "//input[@placeholder='25.50']")private WebElement amountTxtFld;
	
	@FindBy(xpath = "//input[@id='btnSubmit']")private WebElement submitButton;
	
	@FindBy(xpath = "//div[@class='msk-heading']//span[@class='glyphicon glyphicon-remove']")private WebElement closeButton;
	
	
	//initilization
	public TeacherPettyCashPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Utilization
	public WebElement getDiscriptionTxtFld() {
		return discriptionTxtFld;
	}

	public WebElement getAmountTxtFld() {
		return amountTxtFld;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	
	//create a mthod 
	public void discriptionTxtFld(String discp)
	{
		discriptionTxtFld.sendKeys(discp);
	}
	public void amountTxtFld(String amnt) 
	{
		amountTxtFld.sendKeys(amnt);
	}
	public void submitButton() 
	{
		submitButton.click();
		
	}
	public void closeButton()
	{
		closeButton.click();
		
	}

}
