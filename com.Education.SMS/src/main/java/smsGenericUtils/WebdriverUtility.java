package smsGenericUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
{
	/**
	 * this method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	
	/**
	 * this method is used to minimize the browser window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * this method will wait until the page gets load
	 * @param driver
	 */
	public void waitTillPageGetsLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstants.implicitWaitDuration));
		
	}
	
	
	/**
	 * this method wait till element to be visible in the url
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	/**
	 * this method wait till element to click in a UI
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will wait untill the alert to present in UI
	 * @param driver
	 * @return
	 */
	public void waitForAlertPopup(WebDriver driver)
	{
		new WebDriverWait(driver, Duration.ofSeconds(IpathConstants.explicitWaitDuration));
	}
	
	
	/**
	 * this method waits until title to be visible in webpage
	 * @param driver
	 * @param title
	 */
	public void waitForATitle(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	
	/**
	 * this method waits until the url to be visible in the webpage
	 * @param driver
	 * @param url
	 */
	public void waitForUrl(WebDriver driver, String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstants.explicitWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	
	/**
	 * this method will inore if its get nosuchelementexception
	 * @param driver
	 */
	public void ignoreNoSuchElementExc(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstants.explicitWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	
	
	
	/**
	 * this method used to select element in dropdown based on index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropdown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	
	
	
	/**
	 *this method used to select element in dropdown based on value
	 * @param element
	 * @param value
	 */
	public void selectElementInDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * this method used to select element in dropdown based on visibletext
	 * @param text
	 * @param element
	 */
	public void selectElementInDropdown(String text, WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	/**
	 * this method will fetch all the options present in the dropdown
	 * @param element
	 */
	public void getAllOptionFromDropdown(WebElement element)
	{
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) 
		{
			String text = option.getText();
			//System.out.println(text);
			
		}
	}
	
	/**
	 * this method is used to mouse over on the element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	/**
	 * this method is used to perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElementt(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	/**
	 * this method is used to double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElemnt(WebDriver driver,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	/**
	 * this method is used to switch frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * this method is used to switch frame based on id
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}
	
	/**
	 * this method is used to switch frame based on webElement
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	/**
	 * this method is used to switch frame to main frame of a webpage
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 * @param text
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver, String text)
	{
		Alert alt = driver.switchTo().alert();
		if (alt.getText().trim().equalsIgnoreCase(text.trim()))
		{
		//	System.out.println("alert is present");	
		}
		else
		{
		//	System.out.println("alert is not present");
		}
	}
	
	
	/**
	 * this method is used to dismiss the alert popup
	 * @param driver
	 * @param text
	 */
	public void switchToAlertPopupAndDismisst(WebDriver driver, String text)
	{
		Alert alt = driver.switchTo().alert();
		if (alt.getText().trim().equalsIgnoreCase(text.trim()))
		{
			System.out.println("alert is present");
		}
		else
		{
			System.out.println("alert is not present");
		}
	}
	
	
	/**
	 * this method is used to handle fileuploadPopup
	 * @param element
	 * @param path
	 */
	public void fileUpload(WebElement element, String path)
	{
		element.sendKeys(path);
	}
	
	
	/**
	 * this method is used to provide user own polling time
	 * @param duration
	 * @param element
	 * @param pollingTime
	 */
	public void customWait(int duration, WebElement element, long pollingTime)
	{
		int count=0;
		while(count<duration)
		{
			try
			{
				element.click();
				break;
			}
			catch (Exception e)
			{
				try 
				{
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) 
				{
					e1.printStackTrace();
				}
				count++;
			}
		}
	
	}
	
	
	/**
	 * this method is used to get screenshots
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver , String screenShotName) throws IOException
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		LocalDateTime localDateTime = LocalDateTime.now();
		String datetime = localDateTime.toString().replace(" ","_").replace(":","-");
		File dst = new File("./screenshots/"+screenShotName+""+datetime+".png");
		FileUtils.copyFile(src, dst);
		return screenShotName;
	}
	
	
	/**
	 * this method is used to switch to child window
	 * @param driver
	 */
	public void switchWindow(WebDriver driver, String title)
	{
		Set<String> set = driver.getWindowHandles();
		for (String wdw : set) 
		{
			driver.switchTo().window(wdw);
			String text = driver.getTitle();
			if (text.contains(title)) 
			{
				break;
				
			}
			
		}
	}
	
	
	
	
	public void switchingWindow(WebDriver driver, String url)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String text = driver.getCurrentUrl();
			if(text.contains(url))
			{
				break;
			}
		}
	}
}
