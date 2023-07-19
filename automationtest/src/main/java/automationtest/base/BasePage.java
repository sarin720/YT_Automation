package automationtest.base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{


	private static final Duration SECONDS = Duration.ofSeconds(30);

	public void clickAndWait(WebElement ele,WebDriver driver)
	{
		waitForElement(ele,driver);
		ele.click();
	}
	public void click(WebElement ele)
	{

		ele.click();
	}
	public void sendKeys( WebElement ele, String text)
	{
		ele.sendKeys(text);
	}

	public void selectFromDropDown( WebElement ele, String option, String selectByOption )
	{
		Select sel = new Select(ele);

		switch(selectByOption.toLowerCase())
		{
		case "text":

			sel.selectByVisibleText(option);
			break;
		case "value":
			sel.selectByValue(option);
			break;

		case "index":
			sel.selectByIndex(0);
			break;
		}

	}

	public boolean isElementPresent(WebElement ele)
	{
		return !isElementNotPresent(ele);

	}
	public boolean isElementNotPresent(WebElement ele)
	{
		return ele == null;

	}

	public void waitForElement(WebElement ele, WebDriver driver)
	{
		try {

			FluentWait wait = new FluentWait(driver )
					.withTimeout(SECONDS)
					.pollingEvery(SECONDS)
					.ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(ele));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getTitleFromPage(WebDriver driver)
	{
		String val = driver.getTitle();
		return val;
	}

	public String getText(WebElement ele)
	{
		String val;
		if( ele.getText()!= null)
			val = ele.getText();
		else
			val = ele.getAttribute("value");
		return val;
	}

	public WebElement getWebElementFromXpath(String xpath, WebDriver driver)
	{
		return driver.findElement(By.xpath(xpath));
	}


}
