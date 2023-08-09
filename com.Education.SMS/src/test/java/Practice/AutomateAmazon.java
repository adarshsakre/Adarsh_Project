package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import smsGenericUtils.IpathConstants;

public class AutomateAmazon 
{
	@Test
	public void amazon() throws Throwable
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("iphone 13");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		List<WebElement> iphone = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		for (int i = 0; i < iphone.size() ; i++) 
		{
			String phone = iphone.get(i).getText();
			String amount = price.get(i).getText();
			if (phone.contains("Apple iPhone 13 Mini")) 
			{
				System.out.println(phone+" "+amount);
//				String data = phone+" "+amount;
				
				FileInputStream fileInputStream = new FileInputStream("./Iphone.xlsx");
				Workbook workbook = WorkbookFactory.create(fileInputStream);
				Sheet sheet = workbook.getSheet("Sheet1");
				Row row = sheet.createRow(i);
				Cell cell = row.createCell(0);
				cell.setCellValue(phone);
				
				Row row1 = sheet.createRow(i);
				Cell cell1 = row1.createCell(1);
				cell1.setCellValue(amount);
				
				FileOutputStream fileOutputStream = new FileOutputStream("./Iphone.xlsx");
				workbook.write(fileOutputStream);
				workbook.close();
			}
			
		}
		
//		for (WebElement data : iphone) 
//		{
//			String phone = data.getText();
////			System.out.println(phone);
//			if (phone.contains("Apple iPhone 13 Mini")) 
//			{
//				System.out.println(phone);
//			}
//		}
	}
	

}
