package OrganizationTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import objectRepository.CreateorgPage;
import objectRepository.HomePage;
import objectRepository.orgPage;
import objectRepository.orginfoPage;

public class ToCreateOrgTest extends BaseClass {


	@Test(groups="regression")
	
	public void toCreateOrgTest_002() throws EncryptedDocumentException, IOException {
	
		HomePage hpage=new HomePage(driver);
		hpage.getOrganizationslink().click();
		orgPage op=new orgPage(driver);
		op.getOrganizationlookupimage().click();
		CreateorgPage cop=new CreateorgPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		String ORGNAME = eutil.toReadtheDataFfromExcel("Organizations",1,2);
		Random r = new Random();
		int random = r.nextInt(1000);
		cop.getOrganizationname().sendKeys(ORGNAME+random);
		cop.getSaveButton().click();
		orginfoPage oip=new orginfoPage(driver);
		String name = oip.getHeaderVerificationLink().getText();
		//if(name.contains(orgname)) {
			//System.out.println(name+" ...test passed");
		//} 
		//else {
			//System.out.println(name+" ...test failed");
		//}
		//Assert.assertEquals(name.contains(orgname), true);
		Assert.assertTrue(name.contains(ORGNAME));
	
	
	
	

}
}
