package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

import base.BaseClass;

//Page class for BlockingPage, contains all related locators/elements and actions on those
public class BlockingPage extends BaseClass
{
	public WebDriver driver;
	
	public BlockingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private By commandOkMsgEle = By.xpath("//body/*[text()='OK']");
	
	public By redImageFPBefore = By.xpath("//div[@id='full-path-area']/img[@id='full-path-fail-1']");
	public By greenImageFP = By.xpath("//div[@id='full-path-area']//div[@class='testcase-examplecontent']");
	
	public By redImagePPBefore = By.xpath("//div[@id='partial-path-area']/img[@id='partial-path-fail-1']");
	public By greenImagePP = By.xpath("//div[@id='partial-path-area']//div[@class='testcase-examplecontent']");

	public By redImageWildCardBefore = By.xpath("//div[@id='wildcard-area']/img");
	public By redImage1WildCard = By.xpath("//div/img[@id='wildcard-fail-1']");
	public By redImage2WildCard = By.xpath("//div/img[@id='wildcard-fail-2']");
	public By greenImageWildCard = By.xpath("//div[@id='wildcard-area']//div[@class='testcase-examplecontent']");
	
	public By redImageDynamicBefore = By.xpath("//div[@id='blocking-dynamic']/img[@id='dynamic-fail-1']");
	public By greenImageDynamic = By.xpath("//div[@id='blocking-dynamic']//div[@class='testcase-examplecontent']");
	
	public By redImgDeepSubdomainsBefore = By.xpath("//div[@id='deep-subdomains-area']/img[@id='deep-subdomains-fail-1']");
	public By greenImgDeepSubdomains = By.xpath("//div[@id='deep-subdomains-area']//div[@class='testcase-examplecontent']");
	
	public BlockingPage hitCommandAndWaitForSuccess(String command)
	{
		driver.navigate().to(command);
		waitForElementToBeVisible(driver.findElement(commandOkMsgEle));
		return this;
	}
	
	public Boolean isRedImageFPBeforeDisplayed()
	{
		return driver.findElement(redImageFPBefore).isDisplayed();
	}
	
	public Boolean isElementLocatedByDisplayed(By byLocator)
	{
		WebElement element = driver.findElement(byLocator);
		return element.isDisplayed();
	}

}
