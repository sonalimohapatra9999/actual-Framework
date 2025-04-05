package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScriptWithDDT1 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\commonDataproperties1");
		Properties prop = new Properties();
		prop.load(pfis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		
		FileInputStream efis = new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		String ORGANIZATION = wb.getSheet("organization").getRow(1).getCell(2).toString();
		
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			//Step 2 :
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
			driver.findElement(By.id("submitButton")).click();
			
			//step 3 : navigate to contacts link
					driver.findElement(By.linkText("Orgnizations")).click();
					
					//step 4: click on create contact look up image
					driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
					
					//Step 5 : create contact with manadatory field
				driver.findElement(By.name("accountname")).sendKeys(ORGANIZATION);
					
					//step 6 : save and verify
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					if(org.contains(ORGANIZATION)){
						System.out.println(org+"passed");
				
					} else {
					System.out.println(org+"failed");
				}
					
					//step 7 : logout of application
					WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					Actions action =new Actions(driver);
					action.moveToElement(signOut).perform();
					driver.get(URL);
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
					driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
					driver.findElement(By.id("submitButton")).click();
					
					//step 3 : navigate to contacts link
							driver.findElement(By.linkText("Orgnizations")).click();
							
							//step 4: click on create contact look up image
							driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
							
							//Step 5 : create contact with manadatory field
						driver.findElement(By.name("accountname")).sendKeys(ORGANIZATION);
							
							//step 6 : save and verify
							driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
							String org1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
							if(org1.contains(ORGANIZATION)){
								System.out.println(org1+"passed");
						
							} else {
							System.out.println(org1+"failed");
						}
							
							//step 7 : logout of application
							WebElement signOut1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
							Actions action1=new Actions(driver);
							action1.moveToElement(signOut1).perform();
							driver.findElement(By.linkText("Sign Out")).click();
					
					//step 8: close the browser
					driver.quit();
			
			
		}

	}

}
