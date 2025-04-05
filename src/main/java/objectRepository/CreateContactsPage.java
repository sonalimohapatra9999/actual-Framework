package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
	
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
		
		@FindBy(xpath="//input[@name='lastname']")
		 private WebElement lastnameTextField;
		
		
		@FindBy(xpath="//input[@name='lastname']/following-sibling::img")
		 private WebElement organizationlookupimage;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		 private WebElement saveButton;

		public WebElement getLastnameTextField() {
			return lastnameTextField;
		}

		public WebElement getOrganizationlookupimage() {
			return organizationlookupimage;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}

		public WebElement getClickingOnIconLink() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
}
		
		

