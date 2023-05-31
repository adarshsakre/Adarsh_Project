package sms.Subjectrouting.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Petty_cash 
{
	public static void main(String[] args) throws Throwable
	{
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Enter the URL
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		
		//Login as Admin with Usn and Pwd and submit
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("12345");
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
		
		//Enter the Index number
		driver.findElement(By.xpath("//input[@placeholder='Enter index number']")).sendKeys("1212121206");
		
		//Enter the Full name
		driver.findElement(By.xpath("//input[@placeholder='Enter full name']")).sendKeys("name");
		
		//Enter the Initials
		driver.findElement(By.xpath("//input[@placeholder='Enter name with initials']")).sendKeys("vahi6");
		
		//Enter the Address
		driver.findElement(By.xpath("//input[@placeholder='Enter address']")).sendKeys("vahin jaha koi ata jata nahi");
		
		//Select the Gender
		WebElement gender = driver.findElement(By.xpath("//select[@name='gender']"));
		Select select = new Select(gender);
		select.selectByVisibleText("Male");
		
		//Enter phone number
		driver.findElement(By.xpath("//input[@placeholder='123-456-7890']")).sendKeys("889-555-6666");
		
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
		
		
		//Login as Teacher
		driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("t2@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("12345");
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
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("12345");
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
