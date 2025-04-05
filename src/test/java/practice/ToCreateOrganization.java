package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToCreateOrganization {

	public static void main(String[] args) {
		//step1 : To launch  browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//step 2: login to application with valid credentials
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//step 3 : navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4 : click on create organization look up image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 5 : create organization with mantatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qqspiders");
		
		//step 6 :save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org.contains("Qqspiders")) {
			System.out.println(org + "passed");
			
		}else {
			System.out.println("failed to create organization");
		}
		//step 7 :logout
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action =new Actions(driver);
		action.moveToElement(signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 8 : close the browser
		driver.quit();
		
		
		
		
		

	}

}
