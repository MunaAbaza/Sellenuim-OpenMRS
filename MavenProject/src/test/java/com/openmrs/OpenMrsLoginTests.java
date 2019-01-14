package com.openmrs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utility.SelenuimUtils;


public class OpenMrsLoginTests {

	WebDriver driver;
	public String url;
	@Parameters({"browserType","url"})
	@BeforeClass
	public void invokeBrowser(String browserType,String url)
	{

		if(browserType.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE"))
		{
			/**
			 * zoom should be 100%
			 * Protected mode should be enabled for all the security zones..
			 */
			System.out.println("in IEEE");
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserType.equals("CH"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} 
		this.url=url;
	}
	
	@Test	
	public void verifyLogin()
	{
		driver.get(url);   
		try{
			LoginPage lPage = new LoginPage(driver);
			boolean result = lPage.login("Admin", "Admin123");
			SelenuimUtils.captureScreenshot(driver);
			Assert.assertTrue(result);
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
	}
	
	
}
