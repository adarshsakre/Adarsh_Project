package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import smsGenericUtils.IpathConstants;

public class FetchfromExcel
{
	
	@Test(dataProvider = "data")
	public void getData(String From,String To,String Amount)
	{
		System.out.println(From+" "+To+" "+Amount);
	}
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int lastRowNum = sh.getLastRowNum()+1;
		int lastCellNum = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRowNum][lastCellNum];
		for (int i = 0; i < lastRowNum; i++)  //For row
		{
			
			for (int j = 0; j<lastCellNum; j++) //For Column
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return obj;
		
	}

}
