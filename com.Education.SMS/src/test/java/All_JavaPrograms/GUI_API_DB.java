package All_JavaPrograms;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.JavaUtility;

public class GUI_API_DB 
{
	@Test
	public void postProject()
	{
		WebDriverManager.chromedriver().setup();
//		FirefoxDriver driver = new FirefoxDriver();
		 ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084");
		
		driver.findElement(By.xpath("//label[.='Username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//label[.='Password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		
		int random = new JavaUtility().getRandomNumber();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("SMS"+random);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Adarsh Sakre");
		
		WebElement drop = driver.findElement(By.xpath("//label[.='Project Status ']/..//select[@name='status']"));
		Select s = new Select(drop);
		s.selectByVisibleText("Completed");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	}

}

