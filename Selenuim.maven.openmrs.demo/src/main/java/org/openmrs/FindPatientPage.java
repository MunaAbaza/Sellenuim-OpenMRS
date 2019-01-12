package org.openmrs;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class FindPatientPage {
		
		WebDriver driver;
		public FindPatientPage(WebDriver driver) {
			 
			this.driver=driver;
		}
		public boolean findPatient(String patientName)
		{
			driver.findElement(By.id("patient-search")).sendKeys(patientName);
			
			String actual =driver.findElement(By.cssSelector(".odd>td:nth-of-type(2)")).getText();
			//String actual =driver.findElement(By.ByXPath("//*[@id='patient-search-results-table']/tbody/tr[2]/td[2]")).getText();
		
			boolean result;
			result =actual.equals(patientName);
			return result;
		}

		public boolean checkPatientAge(String patientAge)
		{
			driver.findElement(By.id("patient-search")).sendKeys(patientAge);
			String actual =driver.findElement(By.cssSelector(".odd>td:nth-of-type(4)")).getText();
			boolean result;
			result =actual.equals(patientAge);
			return result;
		}
		public boolean checkPatientBirthdate(String patientBirthdate)
		{
			driver.findElement(By.id("patient-search")).sendKeys(patientBirthdate);
			String actual =driver.findElement(By.cssSelector(".odd>td:nth-of-type(5)")).getText();
			boolean result;
			result =actual.equals(patientBirthdate);
			return result;

		}
	}

