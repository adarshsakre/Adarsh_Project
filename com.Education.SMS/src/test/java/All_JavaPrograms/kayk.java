package All_JavaPrograms;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class kayk
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// hit the URL
		driver.get("https://www.kayak.co.in/flights");

		//from
		WebElement from = driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-origin']"));
		from.clear();
		Thread.sleep(2000);
		from.sendKeys("delhi");
		Thread.sleep(2000);

		//to
		WebElement end = driver.findElement(By.xpath("//input[@aria-controls='flight-destination-smarty-input-list']"));
		end.clear();
		Thread.sleep(2000);
		end.sendKeys("banglore");
		Thread.sleep(2000);

		// start date
		WebElement startDate = driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']"));
		startDate.clear();
		Thread.sleep(2000);
		startDate.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("div[aria-label='Saturday 15 July, 2023']")).click();
		Thread.sleep(2000);

		// end date
		WebElement endDate = driver.findElement(By.xpath("//span[@aria-label='End date calendar input']"));
		Thread.sleep(2000);
		endDate.clear();
		endDate.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='Monday 17 July, 2023']")).click();
		Thread.sleep(2000);


		// click on search button
		driver.findElement(By.xpath("//button[@aria-label='Search' and @type='submit']")).click();
		Thread.sleep(2000);

		// get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		String windowHandle = driver.getWindowHandle();

		// switch to child window
		for (String id : windowHandles) {
			if (id != windowHandle) {
				driver.switchTo().window(id);
			}
		}

		// click on travellers button and make adults as 2
		driver.findElement(By.xpath(
				"//div[@class='NITa NITa-travelersCabin NITa-hide-below-m NITa-hasValue NITa-mod-presentation-expanded']"))
		.click();

		driver.findElement(By.xpath(
				"//div[normalize-space()='Travelers']/parent::div//span[normalize-space()='Adults']/parent::label/following-sibling::div//button[@aria-label='Increment']"))
		.click();

		//click on update button
		driver.findElement(By.xpath("//div[@class='zEiP-formField zEiP-submit']//span[.='Update']")).click();

		List<WebElement> all_amount = driver.findElements(By.xpath("//div[@class='yuAt yuAt-pres-rounded']//div[contains(@class,'nrc6-price-section')]"
				+ "//div[contains(@class,'Oihj-bottom-booking')]//div[contains(@class,'f8F1-price-text-container')]"
				+ "/child::div[contains(@class,'f8F1-price-text')]"));

		for (WebElement amount : all_amount) 
		{
			String text = amount.getText();
			System.out.println(text);
		}
	}

}
