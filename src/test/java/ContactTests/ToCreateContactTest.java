package ContactTests;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import objectRepository.ContactsinfoPage;
import objectRepository.Contactspage;
import objectRepository.CreateContactsPage;
import objectRepository.HomePage;
@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateContactTest  extends BaseClass{
	@Test(groups="smoke")
	
	
	public void toCreateContact_001()throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();
		Contactspage cp = new Contactspage(driver);
		cp.getContactslookupimage().click();
		CreateContactsPage ccp= new CreateContactsPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.toReadtheDataFfromExcel("Contacts", 1, 2); 
		ccp.getLastnameTextField().sendKeys(LASTNAME);
		ccp.getSaveButton().click();
		ContactsinfoPage cip = new ContactsinfoPage(driver);
		String lastname = cip.getHeader().getText();
		//Assert.fail();
		//if(lastname.contains(LASTNAME)) {
			//System.out.println(lastname+" ...test passed");
		//}
		//else {
			//System.out.println(lastname+" ...test failed");
		//}
		
		Assert.assertEquals(lastname.contains(LASTNAME), true);
	
	
		
		
		
		
	}
	

}
