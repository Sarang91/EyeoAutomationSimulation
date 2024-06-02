package base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import utility.TestDataReader;

//Base class for all page classes and test classes, contains driver instantiation and common functionalities
public class BaseClass 
{
	public static WebDriver driver;
	WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
  
	public static void readTestData() throws IOException
	{
	   	TestDataReader.readTestData();
	}
	
	public static WebDriver instantiateDriver()
	{
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(co);
		return driver;
	}
	
	public void waitForElementToBeVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeInvisible(WebElement element)
	{
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementsToBeInvisible(List<WebElement> elements)
	{
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
}
