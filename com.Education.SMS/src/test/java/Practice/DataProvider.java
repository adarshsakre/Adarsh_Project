package Practice;

import org.testng.annotations.Test;

public class DataProvider 
{
	
	/*@Test(dataProvider = "data")
	public void getData(String src,String dst,int amount)
	{
		System.out.println("From---->"+src+"To---->"+dst+"Amount---->"+amount);
	}*/
	
	public Object[][] data()
	{



		Object[][] arr = new Object[2][2];
		arr[0][0]="Bengaluru";
		arr[0][1]="kalaburagi";

		arr[1][0]="Qsp";
		arr[1][1]="TY";
		return arr;
	}
	@org.testng.annotations.DataProvider
	public Object[][] data1()
	{



		Object[][] arr = new Object[2][3];
		arr[0][0]="DDT";
		arr[0][1]="Selenium";
		arr[0][2]=120;

		arr[1][0]="A";
		arr[1][1]="B";
		arr[1][2]=420;
		return arr;
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] data2() 
	{
		Object[][] arr=new Object[3][3];
		arr[0][0]="Bengaluru";
		arr[0][1]="kalaburagi";
		arr[0][2]=120;

		arr[1][0]="Qsp";
		arr[1][1]="TY";
		arr[1][2]=420;

		arr[2][0]="Jsp";
		arr[2][1]="TY";
		arr[2][2]=220;
		return arr;
	}
	  
	
	@org.testng.annotations.DataProvider
	public Object[][] data3()
	{
		Object[][] arr=new Object[4][4];
		arr[0][0]="Teacher";
		arr[0][1]="pettycash";
		arr[0][2]=120;
		arr[0][3]=01;

		arr[1][0]="Student";
		arr[1][1]="Mystudent";
		arr[1][2]=420;
		arr[1][3]=02;

		arr[2][0]="Exam";
		arr[2][1]="ExamTimetable";
		arr[2][2]=220;
		arr[2][3]=03;

		arr[3][0]="Subject";
		arr[3][1]="MySubject";
		arr[3][2]=60;
		arr[3][3]=04;
		return arr;

	}
	
	
	
	
	
	@org.testng.annotations.DataProvider
	public Object[][] data4()
	{
		Object[][] arr=new Object[4][5];
		arr[0][0]="Bengaluru";
		arr[0][1]="kalaburagi";
		arr[0][2]=120;
		arr[0][3]=01;
		arr[0][4]="Train";

		arr[1][0]="Qsp";
		arr[1][1]="TY";
		arr[1][2]=420;
		arr[1][3]=02;
		arr[1][4]="Cab";

		arr[2][0]="Jsp";
		arr[2][1]="TY";
		arr[2][2]=220;
		arr[2][3]=03;
		arr[2][4]="Auto";

		arr[3][0]="Rajajinagar";
		arr[3][1]="Banasankari";
		arr[3][2]=60;
		arr[3][3]=04;
		arr[3][4]="Bike";
		return arr;

	}
	
	
	

	 
}
