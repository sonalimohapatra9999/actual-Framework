package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orgPage {
	
	public orgPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
		
	} 
	
	@FindAll({@FindBy(xpath="//img[@title='Create Organization...']"),@FindBy(xpath="//img[@alt='Create Organization...']")})
	 private WebElement organizationlookupimage;

	public WebElement getOrganizationlookupimage() {
		return organizationlookupimage;
	}

	public WebElement getCreateOrganizationLink() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
