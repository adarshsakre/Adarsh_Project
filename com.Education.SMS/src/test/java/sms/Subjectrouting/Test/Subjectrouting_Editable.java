package sms.Subjectrouting.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class Subjectrouting_Editable //TC12
{
	public static void main(String[] args) throws Throwable
	{
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Imported files from Generic utility
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		
		//Maximize
		wLib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		
		//Implicitwait
		wLib.waitTillPageGetsLoad(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Property file import
		String URL = fLib.getPropertyKeyValue("url");
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");
		
		//Login as Teacher
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USNT);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWDT);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on my petty cash
		driver.findElement(By.xpath("//span[.='My Petty Cash']")).click();
		
		//click on add button
		driver.findElement(By.xpath("//a[.='Add ']")).click();
		
		//Enter the details
		driver.findElement(By.xpath("//input[@placeholder='Description 1']")).sendKeys("A");
		driver.findElement(By.xpath("//input[@placeholder='25.50']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Confirmation msg is displayed so to wait for 4 sec used delay
		Thread.sleep(4000);
		
		//click on Exam 
		driver.findElement(By.xpath("//span[.='Exam']")).click();
		
		//click on Exam time table
		driver.findElement(By.xpath("//a[.='Exam Timetable']")).click();
		
		//Enter the details of exam time table
		//select grade from dropdown
		WebElement grade = driver.findElement(By.xpath("//select[@id='grade']"));
		wLib.selectElementInDropdown("ok", grade);
		
		//select exam
		WebElement exam = driver.findElement(By.xpath("//select[@id='exam']"));
		wLib.selectElementInDropdown("ok", exam);
		
		//click on next button
		driver.findElement(By.xpath("//button[.='Next']")).click();
		
		//click on Add button
		driver.findElement(By.xpath("//a[.='Add ']")).click();
		
		//Add subject routing
		//Day dropdown
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		wLib.selectElementInDropdown("Monday", day);
		
		
		//Subject Dropdown
		WebElement subject = driver.findElement(By.xpath("//select[@id='subject']"));
		wLib.selectElementInDropdown("ok", subject);
		
		
		//classroom
		WebElement classroom = driver.findElement(By.xpath("//select[@id='classroom']"));
		Select cls = new Select(classroom);
		cls.selectByVisibleText("ok");
		
		//Start time
		driver.findElement(By.xpath("//input[@id='start_time']")).sendKeys("10");
		
		//End time
		driver.findElement(By.xpath("//input[@id='end_time']")).sendKeys("11");
		
		//click on Submit button
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		Thread.sleep(4000);
		
		//Logout as Teacher
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
		
		//import property files
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		//Login as Admin
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USN);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on subject routing
		driver.findElement(By.xpath("//span[.='Subject Routing']")).click();
		
		//click on search field
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ok");
		
		//click on edit button
		driver.findElement(By.xpath("//a[@onclick='showModal(this)']")).click();
		
		//edit the fees 
		driver.findElement(By.xpath("//input[@id='fee1']")).sendKeys("200");
		
		//click on update button
		driver.findElement(By.xpath("//button[.='Update']")).click();
		
		
		
		
		
	}

}
