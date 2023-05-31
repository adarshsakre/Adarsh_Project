package smsGenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Adarsh
 *
 */
public class JavaUtility 
{
	/**
	 * this method is used to get random number
	 * @return
	 */
	
	public int getRandomNumber()
	{
		Random random = new Random();
		int randNum = random.nextInt(1000);
		return randNum;
	}
	
	/**
	 * this method is used to get current system date in required format
	 * @return
	 */
	public String CurrentSystemDate()
	{
		Date date = new Date();
		String cdate = date.toString();
		return cdate;	
	}
	
	/**
	 * this method is used to get current system datein required format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date date = new Date();
		String cdate = date.toString();
		String[] d = cdate.split(" ");
		
		int month = date.getMonth();
		String week=d[0];
		String Cdate=d[2];
		String year=d[5];
		
		String dateFormat=month+" "+week+" "+Cdate+" "+year;
		return dateFormat;
		
	}
	
	public void robotClass() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}
}
