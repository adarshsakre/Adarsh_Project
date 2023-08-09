package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateFlipkart 
{
	public static void main(String[] args) throws Throwable {
		
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("samsung s20");
		List<WebElement> all = driver.findElements(By.xpath("//span[.='samsung s20']"));
		for (WebElement phones : all)
		{
			String text = phones.getText();
			if (text.equals("samsung s20")) 
			{
				
				System.out.println(text);
				phones.click();
//				Actions a = new Actions(driver);
//				a.moveToElement(phones).click().perform();
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//button[@type='submit']")).click();
//				Thread.sleep(2000);
			}
			
		}

	}

}
