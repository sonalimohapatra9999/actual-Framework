package practice;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import genericUtility.propertyFileUtility;
import objectRepository.CreateorgPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.orgPage;
import objectRepository.orginfoPage;

public class DemoScriptWithDDTandGUandPOMorg {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		propertyFileUtility putil = new propertyFileUtility();
		ExcelFileUtility eutil = new ExcelFileUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		String URL = putil.toReadDataFromPropertyFile("url");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		
		String ORG = eutil.toReadtheDataFfromExcel("Organizations",1,2);
		
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
			  LoginPage lp = new LoginPage(driver);
			  lp.getUsernametTextField().sendKeys(USERNAME);;
			  lp.getPasswordTextField().sendKeys(PASSWORD);;
			  lp.getLoginButton().click();
			  
			  HomePage hp = new HomePage(driver);
			  hp.getOrganizationslink().click();
			  
			  orgPage op = new orgPage(driver);
			  op.getOrganizationlookupimage().click();
			  
			  CreateorgPage cop = new CreateorgPage(driver);
			  cop.getOrganizationname().click();
			  cop.getIndustrDropDown().click();
			  cop.getTypeDropDown().click();
			  cop.getAssignedDropDown().click();
			  cop.getSaveButton().click();
			  
			  orginfoPage oip = new orginfoPage(driver);
			  String orgname = oip.getOrginfo().getText();
			  if(orgname.contains(ORG)) {
				  System.out.println(orgname+"passed");
				  
			  }
			  else {
				  System.out.println(orgname+"failed");
				  
			  }
			  
			  
			  wutil.toMouseHover(driver, hp.getLogoutlink());
			  hp.getSignoutlink().click();
			  
			  driver.quit();
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
		
		
		
		

	}

}
