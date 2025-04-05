package practice;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.propertyFileUtility;

public class DemoScriptWithDDTandGU {

	public static void main(String[] args) throws IOException {
		
		propertyFileUtility putil = new propertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		  
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		
		String LASTNAME = eutil.toReadtheDataFfromExcel("Contacts", 1, 2);
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		  wutil.tomaximize(driver);
		  wutil.toWaitForElements(driver);
		  
		  
		  driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
			driver.findElement(By.id("submitButton")).click();
			
			//step 3 : navigate to contacts link
					driver.findElement(By.linkText("Contacts")).click();
					
					//step 4: click on create contact look up image
					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
					
					//Step 5 : create contact with manadatory field
				driver.findElement(By.name("lastname")).sendKeys("Mohapatra");
					
					//step 6 : save and verify
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					if(lastname.contains("Mohapatra")){
						System.out.println(lastname+"passed");
				
					} else {
					System.out.println(lastname+"failed");
				}
					
					//step 7 : logout of application
					WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			  		wutil.toMouseHover(driver, signOut);
					
					driver.findElement(By.linkText("signout")).click();
					driver.quit();
					
		  
		  
	
		  

	}

}
