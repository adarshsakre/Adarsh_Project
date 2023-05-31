package sms.Subjectrouting.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class verify_subjectrouting //TC09
{
	public static void main(String[] args) throws Throwable 
	{
		
		//Launch the browser
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver(); 
				
				ExcelUtility eLib = new ExcelUtility();
				FileUtility fLib = new FileUtility();
				WebdriverUtility wLib = new WebdriverUtility();
				
				//Fetvh the property files
				String URL = fLib.getPropertyKeyValue("url");
				String USN = fLib.getPropertyKeyValue("usn");
				String PWD = fLib.getPropertyKeyValue("pwd");
				
				//Implicit wait
				wLib.waitTillPageGetsLoad(driver);
				
				//Maximize the browser
				wLib.maximizeWindow(driver);
				
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
				
				//click on the subject
				driver.findElement(By.xpath("//span[.='Subject']")).click();
				
				//Enter the subject Name
				driver.findElement(By.xpath("//input[@placeholder='Enter Subject name']")).sendKeys("ugandains2");
				
				//click on submit button
				driver.findElement(By.xpath("//button[.='Submit']")).click();
				
				Thread.sleep(5000);
				
				//click on the classroom
				driver.findElement(By.xpath("//span[.='Classroom']")).click();
				
				//add the classroom
				driver.findElement(By.xpath("//input[@placeholder='Enter classroom name']")).sendKeys("uganda1");
				driver.findElement(By.xpath("//input[@placeholder='Enter student count']")).sendKeys("69");
				driver.findElement(By.xpath("//button[.='Submit']")).click();
				
				Thread.sleep(5000);
				
				//click on Subject routing
				driver.findElement(By.xpath("//span[.='Subject Routing']")).click();
				
				//click on Add button
				driver.findElement(By.xpath("//a[.='Add ']")).click();
				
				//Enter the details of Grade, Subject, Teacher
				//1 Grade dropdown
				WebElement Grade = driver.findElement(By.xpath("//select[@id='grade']"));
				wLib.selectElementInDropdown("ok", Grade);
				
				//2 Subject dropdown
				WebElement subject = driver.findElement(By.xpath("//select[@id='subject']"));
				wLib.selectElementInDropdown("ok", subject);
				
				//3 Teacher dropdown
				WebElement teacher = driver.findElement(By.xpath("//select[@id='teacher']"));
				wLib.selectElementInDropdown("ok", teacher);
				
				//4 Enter fees
				driver.findElement(By.xpath("//input[@placeholder='Enter subject fee' and @id='fee']")).sendKeys("10");
				
				//click on submit
				driver.findElement(By.xpath("//button[.='Submit']")).click();
				
				
				
				
				
				
				
	
	}
}
