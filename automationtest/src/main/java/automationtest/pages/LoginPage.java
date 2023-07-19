package automationtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import automationtest.base.BasePage;
import utils.Utility_Functions;

public class LoginPage extends BasePage{
	WebDriver driver;
   
    @FindBy(xpath="//input[@id='search']")
    private WebElement search_txt;
    
    @FindBy(xpath="//button[@id='search-icon-legacy']")
    private WebElement search_btn;
    
    @FindBy(xpath="//a[@id='main-link']")
    private WebElement channel_lnk;
    
    @FindBy(xpath="//div[text()='Videos']")
    private WebElement videos_lnk;
  
    @FindBy(xpath="//button[@title='Pause (k)']")
    private WebElement pause_btn;
    
    @FindBy(xpath="//span[@class='ytp-ad-preview-container countdown-next-to-thumbnail']")
    private WebElement countdown;
  
    @FindBy(xpath="//button[@title='Theater mode (t)']")
    private WebElement fullscreen;
  
    @FindBy(xpath="//*[text()='Skip Ads']//parent::button")
    private WebElement skipAd;
  
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	//YT methods
	public void searchForVideo(String search_key) throws InterruptedException
	{
		System.out.println("searching channel name");
		sendKeys(search_txt,"forty3 Stories");
		click(search_btn);
		waitForElement(channel_lnk, driver);
		click(channel_lnk);
		waitForElement(videos_lnk, driver);
		click(videos_lnk);
		System.out.println("Clicked video link");
		waitForElement(driver.findElement(By.xpath("//a[@id='video-title-link' and contains(@title,'"+search_key+"')]")), driver);
		click(driver.findElement(By.xpath("//a[@id='video-title-link' and contains(@title,'"+search_key+"')]")));
		waitForElement(pause_btn,driver);
		System.out.println("clicked pause button");
		//click(pause_btn);
		if(countdown.isDisplayed())
		{
			Thread.sleep(6000);
			click(pause_btn);
			if(skipAd.isDisplayed())
			skipAd.click();
		}
		if(skipAd.isDisplayed())
			if(skipAd.isDisplayed())
			skipAd.click();
		Thread.sleep(4000);
		waitForElement(fullscreen,driver);
		click(fullscreen);
		if(skipAd.isDisplayed())
			skipAd.click();
		Thread.sleep(4000);
		if(countdown.isDisplayed())
		{
			Thread.sleep(6000);
			click(pause_btn);
			if(skipAd.isDisplayed())
			skipAd.click();
		}
		if(skipAd.isDisplayed())
			skipAd.click();
		Thread.sleep(5000);
		if(countdown.isDisplayed())
		{
			Thread.sleep(6000);
			click(pause_btn);
			if(skipAd.isDisplayed())
			skipAd.click();
		}
		Thread.sleep(200000);
		
	}
}
