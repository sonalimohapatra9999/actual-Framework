package ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.ContactsinfoPage;
import objectRepository.Contactspage;
import objectRepository.CreateContactsPage;
import objectRepository.HomePage;

public class ToCreateContactWithOrgTest extends BaseClass{
	@Test(groups="smoke")
	
	public void toCreateContactWithOrgTest_005() throws EncryptedDocumentException, IOException{
		
		HomePage hpage = new HomePage(driver);
		hpage.getOrganizationslink().click();
		
		
		Contactspage cp = new Contactspage(driver);
		cp.getContactslookupimage().click();
		CreateContactsPage Ccp = new CreateContactsPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadtheDataFfromExcel("Contacts", 1, 2);
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.getLastnameTextField().sendKeys(LASTNAME);
		ccp.getOrganizationlookupimage().click();
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.toSwitchWindow(driver, "Accounts");
		driver.findElement(By.xpath("//a[text()='Qqspiders']")).click();
		wutil.toSwitchWindow(driver, "Contacts");
		ccp.getSaveButton().click();
		ContactsinfoPage cip = new ContactsinfoPage(driver);
		String lastname = cip.getHeaderVerificationLink().getText();
		//if(lastname.contains(LASTNAME)) {
			//System.out.println(lastname+"passed");
		//}else {
			//System.out.println(lastname+"failed");
		//} 
		Assert.assertEquals(lastname.contains(LASTNAME), true);
		
		
		
	
	
		
	}

}
