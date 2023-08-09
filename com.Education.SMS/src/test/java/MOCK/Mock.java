package MOCK;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
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

public class Mock 
{
	@Test
	public void pract() throws Throwable, Throwable
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> cont = driver.findElements(By.xpath("//tbody[contains(.,'Country')]//input[@type=\"checkbox\"]/parent::td/following-sibling::td[1]"));
		for (WebElement country : cont)
		{
			String data = country.getText();
			System.out.println(data);
			
			FileInputStream fileInputStream = new FileInputStream(IpathConstants.excelPath);
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.createRow(0);
			Cell cell = row.createCell(1);
			cell.setCellValue(data);
			FileOutputStream fileOutputStream = new FileOutputStream(IpathConstants.excelPath);
			workbook.write(fileOutputStream);
			workbook.close();

		}
	}

}
