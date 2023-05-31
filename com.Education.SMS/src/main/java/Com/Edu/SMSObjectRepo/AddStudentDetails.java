package Com.Edu.SMSObjectRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import smsGenericUtils.ExcelUtility;
import smsGenericUtils.WebdriverUtility;

public class AddStudentDetails 
{
	
	//Declaration
	@FindBy(xpath = "//input[@id='index_number']")private WebElement indexNumberTxtFld;
	
	@FindBy(xpath = "//input[@id='full_name']")private WebElement fullNameTxtFld;
	
	@FindBy(xpath = "//input[@id='i_name']")private WebElement initialNameTxtFld;
	
	@FindBy(xpath = "//input[@id='address']")private WebElement addressTxtFld;
	
	@FindBy(xpath = "//input[@id='email']")private WebElement emailTxtFld;
	
	@FindBy(xpath = "//input[@id='phone']")private WebElement phoneNumberTxtFld;
	
	@FindBy(xpath = "//input[@id='b_date']")private WebElement dateOfBirthTxtFld;
	
	@FindBy(xpath = "//select[@id='gender']")private WebElement genderDropdown;
	
	@FindBy(xpath = "//input[@id='fileToUpload']")private WebElement filepload;
	
	@FindBy(xpath = "//input[@id='g_full_name']")private WebElement guardianFullNameTxtFld;
	
	@FindBy(xpath = "//input[@id='g_i_name']")private WebElement guardianInitialTxtFld;
	
	@FindBy(xpath = "//input[@id='g_address']")private WebElement guardianAddress;
	
	@FindBy(xpath = "//input[@id='g_email']")private WebElement guardianEmailTxtfld;
	
	@FindBy(xpath = "//input[@id='g_phone']")private WebElement guardianPhoneTxtFld;
	
	@FindBy(xpath = "//input[@id='g_b_date']")private WebElement guardianDOB;
	
	@FindBy(xpath = "//select[@id='g_gender']")private WebElement guardianGenderDropdown;
	
	@FindBy(xpath = "//input[@id='g_fileToUpload']")private WebElement guardianFileUpload;
	
	@FindBy(xpath = "//button[@id='btnSubmit']")private WebElement nextButton;
	
	//Initilization
	
	public  AddStudentDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getIndexNumberTxtFld() {
		return indexNumberTxtFld;
	}

	public WebElement getFullNameTxtFld() {
		return fullNameTxtFld;
	}

	public WebElement getInitialNameTxtFld() {
		return initialNameTxtFld;
	}

	public WebElement getAddressTxtFld() {
		return addressTxtFld;
	}

	public WebElement getEmailTxtFld() {
		return emailTxtFld;
	}

	public WebElement getPhoneNumberTxtFld() {
		return phoneNumberTxtFld;
	}

	public WebElement getDateOfBirthTxtFld() {
		return dateOfBirthTxtFld;
	}

	public WebElement getGenderDropdown() {
		return genderDropdown;
	}

	public WebElement getFilepload() {
		return filepload;
	}

	public WebElement getGuardianFullNameTxtFld() {
		return guardianFullNameTxtFld;
	}

	public WebElement getGuardianInitialTxtFld() {
		return guardianInitialTxtFld;
	}

	public WebElement getGuardianAddress() {
		return guardianAddress;
	}

	public WebElement getGuardianEmailTxtfld() {
		return guardianEmailTxtfld;
	}

	public WebElement getGuardianPhoneTxtFld() {
		return guardianPhoneTxtFld;
	}

	public WebElement getGuardianDOB() {
		return guardianDOB;
	}

	public WebElement getGuardianGenderDropdown() {
		return guardianGenderDropdown;
	}

	public WebElement getGuardianFileUpload() {
		return guardianFileUpload;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	//create a method
	
	public void indexNumberTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		indexNumberTxtFld.sendKeys(value);
	}
	
	

	public void fullNameTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		fullNameTxtFld.sendKeys(value);
	}


	public void initialNameTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		initialNameTxtFld.sendKeys(value);
	}

	public void addressTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		addressTxtFld.sendKeys(value);
	}

	public void emailTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		emailTxtFld.sendKeys(value);
	}

	public void phoneNumberTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		phoneNumberTxtFld.sendKeys(value);
	}

	public void dateOfBirthTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		dateOfBirthTxtFld.sendKeys(value);
	}

	public void genderDropdown(WebdriverUtility wLib,String text) throws EncryptedDocumentException, IOException
	{
		wLib.selectElementInDropdown(text, genderDropdown);
	}

	public void filepload(WebdriverUtility wLib,String path) 
	{
		wLib.fileUpload(filepload, path);
	}

	public void guardianFullNameTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		guardianFullNameTxtFld.sendKeys(value);
	}

	public void guardianInitialTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		guardianInitialTxtFld.sendKeys(value);
	}

	public void guardianAddress(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		guardianAddress.sendKeys(value);
	}

	public void guardianEmailTxtfld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		guardianEmailTxtfld.sendKeys(value);
	}

	public void guardianPhoneTxtFld(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		guardianPhoneTxtFld.sendKeys(value);
	}

	public void guardianDOB(ExcelUtility eLib,String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		String value = eLib.getExcelData(sheetname, rowNum, cellNum);
		guardianDOB.sendKeys(value);
	}

	public void guardianGenderDropdown(WebdriverUtility wLib,String text) throws EncryptedDocumentException, IOException
	{
		wLib.selectElementInDropdown(text, guardianGenderDropdown);
	}

	public void guardianFileUpload(WebdriverUtility wLib,String path) throws EncryptedDocumentException, IOException
	{
		wLib.fileUpload(guardianFileUpload, path);
	}

	public void nextButton()
	{
		nextButton.click();
	}

	
}
