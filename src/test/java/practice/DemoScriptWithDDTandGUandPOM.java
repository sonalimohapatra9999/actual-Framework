package practice;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.propertyFileUtility;
import objectRepository.ContactsinfoPage;
import objectRepository.Contactspage;
import objectRepository.CreateContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class DemoScriptWithDDTandGUandPOM {

	public static void main(String[] args) throws IOException {
		propertyFileUtility putil = new propertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		
		//To read from propertyfile
		
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
	    String PASSWORD = putil.toReadDataFromPropertyFile("password");
	   String BROWSER = putil.toReadDataFromPropertyFile("browser");
	   
	   //To Read data from excel file
	   String LASTNAME = eutil.toReadtheDataFfromExcel("Contacts", 1, 2);
	   
	   //launch the browser
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
		  //Login to application with valid credentials
		  
		  driver.get(URL);
		   LoginPage lp = new LoginPage(driver);
		  lp.getUsernametTextField().sendKeys(USERNAME);
		  lp.getPasswordTextField().sendKeys(PASSWORD);
		  lp.getLoginButton().click();
		  //click on contacts link
		  HomePage hp = new  HomePage(driver);
		  hp.getContactslink().click();
		  
		  //step 4 : clickon create contacts look up image
		  
		  Contactspage cp = new Contactspage(driver);
		  cp.getContactslookupimage().click();
		  
		  //step 5 :fill in the blanks
		  CreateContactsPage ccp = new CreateContactsPage(driver);
		  ccp.getLastnameTextField().sendKeys(LASTNAME);
		  
		  //step 6: save and verify
		  ccp.getSaveButton().click();
		  ContactsinfoPage cip = new ContactsinfoPage(driver);
		  String lastname = cip.getHeader().getText();
		  if(LASTNAME.contains(LASTNAME)) {
			  System.out.println(LASTNAME+"passed");
			  
		  }
		  else {
			  System.out.println(LASTNAME+"failed");
		  }
		  
		 // step 7 : logout
		  
		  wutil.toMouseHover(driver, hp.getLogoutlink());
		  hp.getSignoutlink().click();
		  
		  //step 8: close
		  
		  driver.quit();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	   
	   

	}

}
