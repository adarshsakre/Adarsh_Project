package MOCK;

import java.io.FileInputStream;
import java.util.LinkedHashSet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class MockFetch 
{
	@Test
	public void main() throws Throwable, Throwable
	{
		LinkedHashSet<String> map = new LinkedHashSet<String>();
		FileInputStream fis = new FileInputStream("./Mock1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int last = sh.getLastRowNum();
		for (int i=0;i<last;i++)
		{
		String data = sh.getRow(i).getCell(0).getStringCellValue();
		map.add(data);
		}
		System.out.println(map);
		
		
	}

}
