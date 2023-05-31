package sms.Subjectrouting.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class verify_subi_is_displaying 
{
	public static void main(String[] args) throws Throwable
	{
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Importing file from Generic Utility
		WebdriverUtility wLib = new WebdriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		wLib.maximizeWindow(driver);
		
		wLib.waitTillPageGetsLoad(driver);
		
		String URL = fLib.getPropertyKeyValue("url");
		String USNT = fLib.getPropertyKeyValue("usnt");
		String PWDT = fLib.getPropertyKeyValue("pwdt");
		
		//Login to application as Teacher
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USNT);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWDT);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify Dashboard page is displaying
		String url = driver.getCurrentUrl();
		if (url.contains("dashboard2"))
		{
			System.out.println("Teacher Dashboard page is displaying");
			
		}
		else
		{
			System.out.println("Dashboard page is not displaying");
			
		}
		
		//click on my student
		driver.findElement(By.xpath("//span[.='My Student']")).click();
		
		//select a grade from dropdown
		WebElement grade = driver.findElement(By.xpath("//select[@id='grade']"));
		Select g = new Select(grade);
		g.selectByVisibleText("ok");
		
		//click on submit
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		
		//logout as Teacher
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
		
		//property files
		String USNP = fLib.getPropertyKeyValue("usnp");
		String PWDP = fLib.getPropertyKeyValue("pwdp");
		
		//Login as Parent
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USNP);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWDP);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on subject
		driver.findElement(By.xpath("//span[.='Subject']")).click();
		
		//click on all subjects
		driver.findElement(By.xpath("//a[.=' All Subject']")).click();
		
		//logout as Parent
		driver.findElement(By.xpath("//img[@class='user-image']")).click();
		driver.findElement(By.xpath("//a[.='Sign out']")).click();
		
		
		
	}

}
