package sms.Subjectrouting.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.ExcelUtility;
import smsGenericUtils.FileUtility;
import smsGenericUtils.WebdriverUtility;

public class Edit_Student //TC_14
{
	public static void main(String[] args) throws Throwable
	{
		
		//Launch the browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
			
				//Imported from Generic package
				ExcelUtility eLib = new ExcelUtility();
				FileUtility fLib = new FileUtility();
				WebdriverUtility wLib = new WebdriverUtility();
				
				//Implicit wait
				wLib.waitTillPageGetsLoad(driver);
				
				//Maximixze the browser
				wLib.maximizeWindow(driver);
			
				//Fetch from Property files
				String URL = fLib.getPropertyKeyValue("url");
				String USN = fLib.getPropertyKeyValue("usn");
				String PWD = fLib.getPropertyKeyValue("pwd");
				
				//Login as Admin
				driver.get(URL);
				driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(USN);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(PWD);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				//click on student
				driver.findElement(By.xpath("//span[.='Student']")).click();
				
				//click on Add student
				driver.findElement(By.xpath("//a[.=' Add Student']")).click();
				
				//Enter all the Details
				String indexx = eLib.getExcelData("Student", 2, 0);
				driver.findElement(By.xpath("//input[@id='index_number']")).sendKeys(indexx); //Index number
				
				String name = eLib.getExcelData("Student", 2, 1);
				driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys(name);        //Full name
				
				String ini = eLib.getExcelData("Student", 2, 2);
				driver.findElement(By.xpath("//input[@id='i_name']")).sendKeys(ini);			  //Initial name
				
				String Add = eLib.getExcelData("Student", 2, 3);
				driver.findElement(By.xpath("//input[@id='address']")).sendKeys(Add);	  //Address
				
				String mail = eLib.getExcelData("Student", 2, 4);
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mail);     //Email
				
				String phone = eLib.getExcelData("Student", 2, 5);
				driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);	  //Phone number
				
				String dob = eLib.getExcelData("Student", 2, 6);
				driver.findElement(By.xpath("//input[@id='b_date']")).sendKeys(dob);	  //DOB
				
				WebElement Gender = driver.findElement(By.xpath("//select[@id='gender']"));	 	  //Gender dropdown
				wLib.selectElementInDropdown("Male", Gender);
				
				WebElement photo = driver.findElement(By.xpath("//input[@id='fileToUpload']"));   //Upload photo
				photo.sendKeys("C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");
				
				//Enter Guardian details
				String index = eLib.getExcelData("Guardian", 2, 0);
				driver.findElement(By.xpath("//input[@id='g_full_name']")).sendKeys(index);			//Full name
				
				String nameg = eLib.getExcelData("Guardian", 2, 1);
				driver.findElement(By.xpath("//input[@id='g_i_name']")).sendKeys(nameg);			//Initial name
				
				String addr = eLib.getExcelData("Guardian", 2, 2);
				driver.findElement(By.xpath("//input[@id='g_address']")).sendKeys(addr);	//Address
				
				String email = eLib.getExcelData("Guardian", 2, 3);
				driver.findElement(By.xpath("//input[@id='g_email']")).sendKeys(email);		//Email
				
				String phone1 = eLib.getExcelData("Guardian", 2, 4);
				driver.findElement(By.xpath("//input[@id='g_phone']")).sendKeys(phone1);	//phone number
				
				String dob1 = eLib.getExcelData("Guardian", 2, 5);
				driver.findElement(By.xpath("//input[@id='g_b_date']")).sendKeys(dob1);
				
				WebElement gender = driver.findElement(By.xpath("//select[@id='g_gender']"));		//Gender
				wLib.selectElementInDropdown("Male", gender);
				/*Select g1 = new Select(gender);
				g1.selectByVisibleText("Male");*/
				
				driver.findElement(By.xpath("//input[@id='g_fileToUpload']")).sendKeys("C:\\Users\\Adarsh\\Desktop\\Test Yantra\\Photo.jpg");
				driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();				  //Click on next button
				
				
				//select grade form dropdown
				WebElement sgrade = driver.findElement(By.xpath("//select[@id='grade']"));
				wLib.selectElementInDropdown("ok", sgrade);
				
				//click on submit by selecting check box
				driver.findElement(By.xpath("//input[@id='checkbox']")).click();
				
				//click on submit button
				driver.findElement(By.xpath("//button[@id='btnSubmit1']")).click();
				
	}

}
