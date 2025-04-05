package OrganizationTest;

import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreateorgPage;
import objectRepository.HomePage;
import objectRepository.orgPage;
import objectRepository.orginfoPage;

public class ToCreateOrgWithTypeTest extends BaseClass {
	private CharSequence orgname;

	@Test(groups="regression")
	
	
	public void toCreateOrgWithTypeTest_004() throws  EncryptedDocumentException, Exception{
		
		HomePage hpage=new HomePage(driver);
		hpage.getOrganizationslink().click();
		orgPage op=new orgPage(driver);
		op.getOrganizationlookupimage().click();
		CreateorgPage cop=new CreateorgPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String ORGNAME = eutil.toReadtheDataFfromExcel("Organizations",4,2);
		Random r  = new Random();
		int random = r.nextInt(1000);
		cop.getOrganizationname().sendKeys(ORGNAME+random);
		 String IndustryDropDown = eutil.toReadtheDataFfromExcel("Organizations",4,3);
		 cop.getIndustrDropDown().sendKeys(IndustryDropDown);
		 cop.getSaveButton().click();
		orginfoPage oip=new orginfoPage(driver);
		String name = oip.getHeaderVerificationLink().getText();
		//if(name.contains(orgname)) {
			//System.out.println(name+" ...test passed");
		//}
		//else {
			//System.out.println(name+" ...test failed");
		//}
		Assert.assertEquals(name.contains(ORGNAME), true);
		
	
	 

}
}
