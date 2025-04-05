package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToCreateChemicals {

	public static void main(String[] args) {
	
		//Step 1: launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//step 2 : login to application with valid credentials
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//step 3: navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4: click on create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 5: create organization with mandatory fields
		Random r = new Random();
		int random = r.nextInt(1000);
		
		driver.findElement(By.name("accountname")).sendKeys("Qqspiders"+random);
		
		//step 6: select "chemicals" in the industry dropdown
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		Select  industry= new Select(industrydropdown);
		industry.selectByVisibleText("Chemicals");
		
		//step 7:save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org.contains("Qqspiders"+random)) {
			System.out.println(org + "passed");
			
		}else {
			System.out.println("failed to create organization");
		}
		
		//step 8:logout of application
		WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action =new Actions(driver);
		action.moveToElement(signOut).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//step 9 :  close the server
		driver.quit();
		
		
		
		
		
		
		
		
		
		

	}

}
