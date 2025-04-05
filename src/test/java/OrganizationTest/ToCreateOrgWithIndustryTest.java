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

public class ToCreateOrgWithIndustryTest extends BaseClass {



	@Test(groups="regression")
	
	public void toCreateOrgTest_003() throws EncryptedDocumentException, IOException {
		
		HomePage hpage=new HomePage(driver);
		hpage.getOrganizationslink().click();
		orgPage op=new orgPage(driver);
		op.getOrganizationlookupimage().click();
		CreateorgPage cop=new CreateorgPage(driver);
		ExcelFileUtility eutil=new ExcelFileUtility();
		Random r = new Random();
		int random = r.nextInt(1000);
	    String ORGNAME = eutil.toReadtheDataFfromExcel("Organizations",7,2);
		cop.getOrganizationname().sendKeys(ORGNAME+random);
		String Industry= eutil.toReadtheDataFfromExcel("Organizations", 7, 3);
		cop.getIndustrDropDown().sendKeys(Industry);
	     String Type = eutil.toReadtheDataFfromExcel("Organizations", 7, 4);
	     cop.getTypeDropDown().sendKeys(Type);
		
		cop.getSaveButton().click();
		orginfoPage oip=new orginfoPage(driver);
		String name = oip.getHeaderVerificationLink().getText();
		//if(name.contains(orgname)) {
			//System.out.println(name+" ...test passed");
		//}
		//else {
		//	System.out.println(name+" ...test failed");
		Assert.assertEquals(name.contains(ORGNAME), true);
		
		
		
		
		
		
		
		
		
		
		
	}
	}

