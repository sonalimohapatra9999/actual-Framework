package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.propertyFileUtility;

public class DemoScriptWithGenericUtility {
	
	
		
		public static void main(String[] args) throws IOException {
			
			//To read the data from property file
			propertyFileUtility putil = new propertyFileUtility();
			String URL = putil.toReadDataFromPropertyFile("url");
			String USERNAME = putil.toReadDataFromPropertyFile("username");
			String PASSWORD = putil.toReadDataFromPropertyFile("password");
			String BROWSER = putil.toReadDataFromPropertyFile("browser");
			
			//To Read the Data from excel file
			ExcelFileUtility eutil = new ExcelFileUtility();
			String LASTNAME = eutil.toReadtheDataFfromExcel("Contacts",1,2);
			
		//step 1: launch browser
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
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
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
					
					
					WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					Actions action =new Actions(driver);
					action.moveToElement(signOut).perform();
					driver.findElement(By.linkText("Sign Out")).click();
					
					driver.quit();
					
				}
			
			
		
			
			}
			
		}
		
		
	


