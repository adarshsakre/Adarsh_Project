package Com.Edu.SMSObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonComponentsPage 
{
	//declaration
	
	//Submit button
	@FindBy(xpath = "//button[.='Submit']")private WebElement submitButton;
	
	//Add button
	@FindBy(xpath = "//a[.='Add ']")private WebElement addButton;
	
	//search
	@FindBy(xpath = "//input[@type='search']")private WebElement searchTxtFld;

	//Update 
	@FindBy(xpath = "//button[.='Update']")private WebElement updateButton;

	//Initialization
	public CommonComponentsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getSubmitButton() {
		return submitButton;
	}


	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	
	public WebElement getSearchTxtFld() {
		return searchTxtFld;
	}

	//create method 
	public void submitButton()
	{
		submitButton.click();
	}
	
	public void addButton()
	{
		addButton.click();
	}
	public void searchTxtFld(String text) 
	{
		searchTxtFld.sendKeys(text);
		
	}
	public void updateButton()
	{
		updateButton.click();
	}
}
