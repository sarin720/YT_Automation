package automationtest.tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import automationtest.base.BaseTest;
import automationtest.pages.LoginPage;
import utils.DataGenerator;
public class LoginEdgeTest extends BaseTest

{

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException
	{
		setup("firefox");
		loginPage = new LoginPage(driver);
		
	}

	
	@Test(dataProvider = "data-provider", dataProviderClass = DataGenerator.class)
	public void searchForVideo(String video_name) throws InterruptedException
	{
		loginPage.searchForVideo(video_name);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		tearDown();

	}
}
