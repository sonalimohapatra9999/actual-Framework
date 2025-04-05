package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateorgPage {
	
	public CreateorgPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
		
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	 private WebElement organizationlookupimage;
	
	@FindBy(name="accountname")
	 private WebElement organizationname;
	
	
	@FindBy(name="industry")
	 private WebElement industrDropDown ;
	
	@FindBy(name="accounttype")
	 private WebElement  typeDropDown;
	
	@FindBy(name="assigned_user_id")
	 private WebElement assignedDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	 private WebElement saveButton;

	public WebElement getOrganizationlookupimage() {
		return organizationlookupimage;
	}

	public WebElement getOrganizationname() {
		return organizationname;
	}

	public WebElement getIndustrDropDown() {
		return industrDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getAssignedDropDown() {
		return assignedDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	
	
	

}
