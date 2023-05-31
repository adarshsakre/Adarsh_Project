package Practice;

import org.testng.annotations.Test;

public class Practice
{
	
	
	@Test(invocationCount = 1)
	public void create()
	{
		System.out.println("Create");
	}
	
	
	@Test(priority = -5 )
	public void update()
	{
		System.out.println("Update");
	}
	
	
	@Test
	public void delete()
	{
		System.out.println("Delete");
	}
}
