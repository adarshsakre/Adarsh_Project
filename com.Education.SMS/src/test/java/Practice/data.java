package Practice;

import org.testng.annotations.Test;

public class data
{

	//2*3 
	@Test(dataProviderClass = DataProvider.class,dataProvider = "data1")
	public void getData(String src,String dst,int amount)
	{
		System.out.println("From---->"+src+"To---->"+dst+"Amount---->"+amount);
	}

	//3*3
	@Test(dataProviderClass = DataProvider.class,dataProvider = "data2")
	public void getData1(String src,String dst,int amount)
	{
		System.out.println("From---->"+src+"To---->"+dst+"Amount---->"+amount);
	}

	//4*4
	@Test(dataProviderClass =  DataProvider.class,dataProvider = "data3")
	public void getData(String src,String dst,int amount,int Slno)		
	{
		System.out.println("From---->"+src+"To---->"+dst+"Amount---->"+amount+"Slno---->"+Slno);


	}
	//4*5
	@Test(dataProviderClass = DataProvider.class,dataProvider = "data4")
	public void getData(String src,String dst,int amount,int Slno,String via)		
	{
		System.out.println("From---->"+src+"To---->"+dst+"Amount---->"+amount+"Slno---->"+Slno+"By---->"+via);


	}
}
