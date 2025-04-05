package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsinfoPage {
	
	
	public ContactsinfoPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
		
		
		@FindBy(xpath="//span[@class='dvHeaderText']")
		 private WebElement header;


		public WebElement getHeader() {
			return header;
		}


		public WebElement getHeaderVerificationLink() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	
	
	
	
	


