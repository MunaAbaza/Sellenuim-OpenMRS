package org.openmrs;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		 //modify
		this.driver = driver;
	}
	public boolean login(String uname,String pword) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).submit();
		boolean result = driver.getTitle().contains("Home");
		return result;
	}
}


