package Com.Edu.SMSObjectRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class AddTeacherPage 
{

	//Declaration
	@FindBy(xpath = "//input[@placeholder='Enter index number']")private WebElement indexNumber;

	@FindBy(xpath = "//input[@placeholder='Enter full name']")private WebElement fullname;

	@FindBy(xpath = "//input[@placeholder='Enter name with initials']")private WebElement nameWithInitials;

	@FindBy(xpath = "//input[@placeholder='Enter address']")private WebElement address;

	@FindBy(xpath = "//select[@name='gender']")private WebElement genderDropdown;

	@FindBy(xpath = "//input[@placeholder='123-456-7890']")private WebElement phoneNumber;

	@FindBy(xpath = "//input[@placeholder='Enter valid email address']")private WebElement emailAddress;

	@FindBy(xpath = "//input[@name='fileToUpload']")private WebElement fileUpload;
	
	
	@FindBy(xpath = "//button[.='Submit']")private WebElement submitButton;

	//Initialization

	public WebElement getSubmitButton() {
		return submitButton;
	}


	public AddTeacherPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getIndexNumber() {
		return indexNumber;
	}

	public WebElement getFullname() {
		return fullname;
	}

	public WebElement getNameWithInitials() {
		return nameWithInitials;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getGenderDropdown() {
		return genderDropdown;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getFileUpload() {
		return fileUpload;
	}

	//create a method for Add teacher
	public void indexNumberTxtFld(ExcelUtility eLib, String sheetName, int rowNum,int cellNum,JavaUtility jLib) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetName, rowNum, cellNum);
		indexNumber.sendKeys(value+jLib.getRandomNumber());	
	}
	public void fullnameTxtfld(ExcelUtility eLib,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetName, rowNum, cellNum);
		fullname.sendKeys(value);
		
	}
	
	public void nameWithInitials(ExcelUtility eLib,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetName, rowNum, cellNum);
		nameWithInitials.sendKeys(value);
	}
	
	public void address(ExcelUtility eLib,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetName, rowNum, cellNum);
		address.sendKeys(value);
	}
	
	public void genderDropdown(WebdriverUtility wLib,String text) throws EncryptedDocumentException, IOException
	{
		
		wLib.selectElementInDropdown(text, genderDropdown);
	}
	
	public void phoneNumber(ExcelUtility eLib,String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetName, rowNum, cellNum);
		phoneNumber.sendKeys(value);
	}
	
	public void emailAddress(ExcelUtility eLib,String sheetName,int rowNum,int cellNum,JavaUtility jLib) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetName, rowNum, cellNum);
		emailAddress.sendKeys(jLib.getRandomNumber()+value);
	}
	
	
	public void fileUpload(WebdriverUtility wLib,String path) 
	{
		wLib.fileUpload(fileUpload,path);
	}
	
	public void submitButton()
	{
		submitButton.click();
	}
	
	
	


}
