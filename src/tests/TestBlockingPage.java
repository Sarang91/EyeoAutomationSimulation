package tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.BlockingPage;
import base.BaseClass;
import utility.TestDataReader;
import utility.UrlEncoder;

//Test Class for BlockingPage - Contains tests of BlockingPage 
public class TestBlockingPage extends BaseClass
{
	public WebDriver driver;
	
	@Before
	public void BeforeTest() throws IOException
	{
		readTestData();
		driver = instantiateDriver();
		driver.get(TestDataReader.blockingPageUrl);
	}
	
	@Test
	public void testFullPath()
	{
		String command = TestDataReader.commandtoAddFilter+UrlEncoder.encodeValue(TestDataReader.fullPathFilter);

		BlockingPage blockingPage = new BlockingPage(driver);
		
		waitForElementToBeVisible(driver.findElement(blockingPage.redImageFPBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.redImageFPBefore));
		blockingPage.hitCommandAndWaitForSuccess(command);
		driver.navigate().to(TestDataReader.blockingPageUrl);
		
		waitForElementToBeInvisible(driver.findElement(blockingPage.redImageFPBefore));
		Assert.assertFalse(blockingPage.isElementLocatedByDisplayed(blockingPage.redImageFPBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.greenImageFP));   
	}

	@Test
	public void testPartialPath()
	{
		String command = TestDataReader.commandtoAddFilter+UrlEncoder.encodeValue(TestDataReader.partialPathFilter);

		BlockingPage blockingPage = new BlockingPage(driver);
		
		waitForElementToBeVisible(driver.findElement(blockingPage.redImagePPBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.redImagePPBefore));
		blockingPage.hitCommandAndWaitForSuccess(command);
		driver.navigate().to(TestDataReader.blockingPageUrl);
		waitForElementToBeInvisible(driver.findElement(blockingPage.redImagePPBefore));
		Assert.assertFalse(blockingPage.isElementLocatedByDisplayed(blockingPage.redImagePPBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.greenImagePP));   
	}
	
	@Test
	public void testWildCard()
	{
		String command = TestDataReader.commandtoAddFilter+UrlEncoder.encodeValue(TestDataReader.wildCardFilter);

		BlockingPage blockingPage = new BlockingPage(driver);
		
		waitForElementToBeVisible(driver.findElement(blockingPage.redImage1WildCard));
		waitForElementToBeVisible(driver.findElement(blockingPage.redImage2WildCard));
		List<WebElement> redImagesWildCard = driver.findElements(blockingPage.redImageWildCardBefore);
		Assert.assertEquals(2, redImagesWildCard.size());
		blockingPage.hitCommandAndWaitForSuccess(command);
		driver.navigate().to(TestDataReader.blockingPageUrl);
		waitForElementsToBeInvisible(driver.findElements(blockingPage.redImageWildCardBefore));
		
		Assert.assertFalse(blockingPage.isElementLocatedByDisplayed(blockingPage.redImage1WildCard));
		Assert.assertFalse(blockingPage.isElementLocatedByDisplayed(blockingPage.redImage2WildCard));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.greenImageWildCard));   
	}
	
	@Test
	public void testDynamic()
	{
		String command = TestDataReader.commandtoAddFilter+UrlEncoder.encodeValue(TestDataReader.dynamicFilter);

		BlockingPage blockingPage = new BlockingPage(driver);
		
		waitForElementToBeVisible(driver.findElement(blockingPage.redImageDynamicBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.redImageDynamicBefore));
		blockingPage.hitCommandAndWaitForSuccess(command);
		driver.navigate().to(TestDataReader.blockingPageUrl);
		waitForElementToBeInvisible(driver.findElement(blockingPage.redImageDynamicBefore));
		Assert.assertFalse(blockingPage.isElementLocatedByDisplayed(blockingPage.redImageDynamicBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.greenImageDynamic));   
	}
	
	@Test
	public void testDeepSubdomains()
	{
		String command = TestDataReader.commandtoAddFilter+UrlEncoder.encodeValue(TestDataReader.deepDomainsFilter);

		BlockingPage blockingPage = new BlockingPage(driver);
		
		waitForElementToBeVisible(driver.findElement(blockingPage.redImgDeepSubdomainsBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.redImgDeepSubdomainsBefore));
		blockingPage.hitCommandAndWaitForSuccess(command);
		driver.navigate().to(TestDataReader.blockingPageUrl);
		waitForElementToBeInvisible(driver.findElement(blockingPage.redImgDeepSubdomainsBefore));
		Assert.assertFalse(blockingPage.isElementLocatedByDisplayed(blockingPage.redImgDeepSubdomainsBefore));
		Assert.assertTrue(blockingPage.isElementLocatedByDisplayed(blockingPage.greenImgDeepSubdomains));   
	}

	
	@After
	public void AfterTest()
	{
		driver.close();
	}
}
