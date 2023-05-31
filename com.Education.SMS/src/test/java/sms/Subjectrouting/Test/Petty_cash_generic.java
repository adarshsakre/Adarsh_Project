package sms.Subjectrouting.Test;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class Petty_cash_generic 
{
	public static void main(String[] args) throws Throwable
	{
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		
		//Implicit wait
		wLib.waitTillPageGetsLoad(driver);
		
		
		//Maximize the browser
		wLib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		
		
		//fetching data from fileutility of admin
		String URL = fLib.getPropertyKeyValue("url");
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		//Enter the URL
		
		driver.get(URL);
		
		//Login as Admin with Usn and Pwd and submit
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USN);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//verify the Admin Dashboard page using URL
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("dashboard"))
		{
			System.out.println("Dashboard page is Displayed");
			
		}
		else 
		{
			System.out.println("Dashboard page is not Displayed");
		}
		/*
		      //we can use any one method for validation 
		//verify the Admin Dashboard page using Title
		String title = driver.getTitle();
		if (title.contains("Student Management System")) 
		{
			System.out.println("yes");
			
		}
		else
		{
			System.out.println("NO");
			
		}
		*/
		
		//Click on Teacher Button
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		
		//Click on Add teacher Link
		driver.findElement(By.xpath("//a[.=' Add Teacher']")).click();
		
				//Enter the Index number from excel
		String index = eLib.getExcelData("Sheet1",3,0);
		driver.findElement(By.xpath("//input[@placeholder='Enter index number']")).sendKeys(index);
		
		/*
		FileInputStream fileInputStream = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb = WorkbookFactory.create(fileInputStream);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(0);
		String data = cell.toString();
		
		System.out.println(data);*/
		
		
		
		//Enter the Full name
		String name = eLib.getExcelData("Sheet1",3, 1);
		driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).sendKeys(name);

		
		//Enter the Initials
		String full = eLib.getExcelData("Sheet1", 3, 2);
		driver.findElement(By.xpath("//input[@placeholder='Enter name with initials']")).sendKeys(full);
		
		
		//Enter the Address
		String add = eLib.getExcelData("Sheet1", 3, 3);
		driver.findElement(By.xpath("//input[@placeholder='Enter address']")).sendKeys(add);
		
		//Select the Gender
		WebElement gender = driver.findElement(By.xpath("//select[@name='gender']"));
		Select select = new Select(gender);
		select.selectByVisibleText("Male");
		
		//Enter phone number
		String phone = eLib.getExcelData("Sheet1", 3, 4);
		driver.findElement(By.xpath("//input[@placeholder='123-456-7890']")).sendKeys(phone);
		
		//Enter Mail id
		driver.findElement(By.xpath("//input[@placeholder='Enter valid email address']")).sendKeys("6a@gmail.com");
		
		//Upload photo
		WebElement photo = driver.findElement(By.xpath("//input[@name='fileToUpload']"));
		photo.sendKeys("C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");
		
		//verify file has uploaded
		
		
		//click on Submit button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(4000);
		
		
		//Click on Teacher Button
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		
		//Click on All teacher Link
		driver.findElement(By.xpath("//a[.=' All Teacher']")).click();
		
		//search a teacher
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("vahi");
		
		//signOut as Admin
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
		//Fetch data of Teacher from FileUtility
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");
		
		//Login as Teacher
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USNT);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWDT);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on My petty cash
		driver.findElement(By.xpath("//a[@href='my_petty_cash.php']")).click();
		
		//click on Add button
		driver.findElement(By.xpath("//a[.='Add ']")).click();
		
		//Add description and money
		driver.findElement(By.xpath("//input[@placeholder='Description 1']")).sendKeys("Chalk");
		driver.findElement(By.xpath("//input[@placeholder='25.50']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		Thread.sleep(4000);
		
		//Search for Petty cash
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("2023-05-15");
		
		//signout as teacher
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
		//Login as Admin
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USN);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on petty cash
		driver.findElement(By.xpath("//span[.='Petty Cash']")).click();
		
		//Enter the details of teacher
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Teacher 2");
		
		//Approve
		driver.findElement(By.xpath("//a[@id='aApprove_5']")).click();
		
		driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();
		
	}

}
