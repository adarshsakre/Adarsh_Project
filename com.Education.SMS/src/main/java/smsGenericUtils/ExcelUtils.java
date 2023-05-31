package smsGenericUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtils
{

	public Object[][] readData(String SheetName) throws EncryptedDocumentException, IOException
	{


		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRowNum = sh.getLastRowNum()+1;
		int lastCellNum = sh.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRowNum][lastCellNum];

		for (int i = 0; i < lastRowNum ; i++) 
		{
			for (int j = 0; j < lastCellNum; j++) 
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();

			}

		}
		return obj;
	}




	//HP01
	public HashMap<String,String> getMultipledate(String SheetName) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i < count; i++) 
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}

}
