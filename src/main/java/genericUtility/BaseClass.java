package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	propertyFileUtility putil = new propertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"smoke","regression"})
	public void beforeSuiteConfiguration() {
		Reporter.log("...Database connection established.....",true);
		
		
		
	}
	//@Parameters("browser")//cross browser Testing
	//@BeforeTest // cross browser Testing
	@BeforeClass(groups={"smoke","regression"})
	public void beforeClassConfiguration(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		if(BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.contains("edge")) {
			driver = new EdgeDriver();
				
			}else if (BROWSER.contains("firefox")) {
				driver = new FirefoxDriver();
				
			}
		sdriver=driver;
			Reporter.log("Browser got Launched",true);
			wutil.tomaximize(driver);
			wutil.toWaitForElements(driver);
			driver.get(URL);
		
		}
		
		@BeforeMethod(groups={"smoke","regression"})
		public void beforeMethodConfiguration() throws IOException {
			String USERNAME = putil.toReadDataFromPropertyFile("username");
			String PASSWORD = putil.toReadDataFromPropertyFile("password");
			LoginPage lp = new LoginPage(driver);
			lp.getUsernametTextField().sendKeys(USERNAME);
			lp.getPasswordTextField().sendKeys(PASSWORD);
			lp.getLoginButton().click();
			Reporter.log("Logged In successfully",false);
			
			
			
			
		}
		
		@AfterMethod(groups={"smoke","regression"})
		public void afterMethodConfiguration() {
			HomePage hp = new HomePage(driver);
			wutil.toMouseHover(driver, hp.getLogoutlink());
			hp.getSignoutlink().click();
			Reporter.log("Logged Out successfully",false);
		}
		
		@AfterClass(groups={"smoke","regression"})
		public void afterClassConfiguration() {
			Reporter.log("Browser got closed Successfully",true);
			driver.quit();
			
		}
		@AfterSuite(groups={"smoke","regression"})
		public void afterSuiteConfiguration() {
			Reporter.log("Database Conection Disconnected",true);
		}
		
		

	
	

}

