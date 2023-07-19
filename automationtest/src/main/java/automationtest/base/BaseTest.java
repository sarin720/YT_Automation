package automationtest.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationtest.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public abstract class BaseTest{
	public RemoteWebDriver driver;
	public WebDriverWait wait;

    public LoginPage loginPage;
	
	
	public void setup(String browser) throws MalformedURLException
	{
		
		if(Constants.isRemote)
			setupRemoteDriver(browser);
		else
		
			setupDriver(browser);
			
		
		driver.get(Constants.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


	}

	private void setupDriver(String browser) 
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);
		}
		else if(browser.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if(browser.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();

	}

	private void setupRemoteDriver(String browser) throws MalformedURLException
	{
		System.out.println("progressing to initialise DC");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		System.out.println("Initialised DC");
	}

	
	public void tearDown()
	{
             driver.quit();
	}

	

}
