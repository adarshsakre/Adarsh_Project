package sms.Subjectrouting.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.JavaUtility;
import smsGenericUtils.WebdriverUtility;

public class Add_Subjectrouting //TC_25
{
	public static void main(String[] args) throws Throwable
	{
		
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Import generic files
		WebdriverUtility wLib = new WebdriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		
		wLib.waitTillPageGetsLoad(driver);
		wLib.maximizeWindow(driver);
		
		//fetch property files
		String URL = fLib.getPropertyKeyValue("url");
		String USN = fLib.getPropertyKeyValue("usn");
		String PWD = fLib.getPropertyKeyValue("pwd");
		
		//Login as Admin
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on teacher button
		driver.findElement(By.xpath("//span[.='Teacher']")).click();
		
		//click on Add teacher
		driver.findElement(By.xpath("//a[.=' Add Teacher']")).click();
		
		//Enter the Index number
				String index1 = eLib.getExcelData("Sheet1", 3, 8);
				driver.findElement(By.xpath("//input[@placeholder='Enter index number']")).sendKeys(index1);
				
				//Enter the Full name
				String name = eLib.getExcelData("Sheet1", 3, 9);
				driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).sendKeys(name);
				
				//Enter the Initials
				String ini = eLib.getExcelData("Sheet1", 3, 10);
				driver.findElement(By.xpath("//input[@placeholder='Enter name with initials']")).sendKeys(ini);
				
				//Enter the Address
				String add = eLib.getExcelData("Sheet1", 3, 11);
				driver.findElement(By.xpath("//input[@placeholder='Enter address']")).sendKeys(add);
				
				//Select the Gender
				WebElement gender = driver.findElement(By.xpath("//select[@name='gender']"));
				wLib.selectElementInDropdown("Male", gender);
				
				
				//Enter phone number
				String phone = eLib.getExcelData("Sheet1", 3, 12);
				driver.findElement(By.xpath("//input[@placeholder='123-456-7890']")).sendKeys(phone);
				
				//Enter Mail id
				String email = eLib.getExcelData("Sheet1", 3, 13);
				driver.findElement(By.xpath("//input[@placeholder='Enter valid email address']")).sendKeys(email);
				
				//Upload photo
				WebElement photo = driver.findElement(By.xpath("//input[@name='fileToUpload']"));
				photo.sendKeys("C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");
				
				//click on time table
				driver.findElement(By.xpath("//span[.='Timetable']")).click();
				
				//select grade from dropdown
				WebElement grade = driver.findElement(By.xpath("//select[@id='grade']"));
				wLib.selectElementInDropdown("ok", grade);
				
				
				//click on Submit
				driver.findElement(By.xpath("//button[.='Submit']")).click();
				
				//click on Add
				driver.findElement(By.xpath("//a[.='Add ']")).click();
				
				//select subject from drop down
				WebElement sub = driver.findElement(By.xpath("//select[@id='subject']"));
				wLib.selectElementInDropdown("ok", sub);
				
				
				//select teacher from drop down
				WebElement teach = driver.findElement(By.xpath("//select[@id='teacher']"));
				wLib.selectElementInDropdown("ok", teach);
				
				
				String text = teach.getText();
				if (text.contains("ok"))
				{
					System.out.println("present");
					
				}
				else
				{
					System.out.println("no");
					
				}
					
				}
	/*
				boolean b = teach.isSelected();
				if (b) 
				System.out.println("teacher is selected");
				else
					System.out.println("teacher is not selected");  */
	
}
