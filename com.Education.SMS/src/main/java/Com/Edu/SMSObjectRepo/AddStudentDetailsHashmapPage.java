package Com.Edu.SMSObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddStudentDetailsHashmapPage //HP01
{
	public void  addStudent(HashMap<String, String> fields, WebDriver driver)
	{
		
		for (Entry<String, String> set:fields.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}	
	
}