package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage {

	
	public Contactspage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
		
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		 private WebElement contactslookupimage;
		

		public WebElement getContactslookupimage() {
			return contactslookupimage;
		}


		public WebElement getCreateContactsLink() {
			// TODO Auto-generated method stub
			return null;
		}

		
		}
		
		
		
		
		
		


