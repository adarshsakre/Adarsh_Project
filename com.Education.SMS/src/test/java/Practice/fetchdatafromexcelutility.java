package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import smsGenericUtils.ExcelUtils;

public class fetchdatafromexcelutility 
{
	@Test(dataProvider = "getData")
	public void data(String src,String dst,String amount) throws EncryptedDocumentException, IOException
	{
		System.out.println(src+" "+dst+" "+amount);
	
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtils eUtils = new ExcelUtils();
		Object[][] data = eUtils.readData("DataProvider");
		return data;
		
	}

}
