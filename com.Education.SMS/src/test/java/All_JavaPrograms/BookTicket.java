package All_JavaPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BookTicket 
{
	@Test
	public void book() throws Throwable
	{
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.kayak.co.in/");
		
		driver.findElement(By.xpath("//div[@class='vvTc-item-button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From?']")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To?']")).sendKeys("Kalaburagi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Gulbarga, Karnataka, India']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		driver.findElement(By.xpath("//div[.='July 2023']/../..//div[.='15']")).click();
		driver.findElement(By.xpath("//div[.='August 2023']/../..//div[.='15']")).click();
		driver.findElement(By.xpath("//div[@class='keel-container form-container s-t-bp no-edges edges-s']//button[@role='button']")).click();
	}

}
