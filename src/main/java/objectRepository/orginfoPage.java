package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orginfoPage {
	
	public orginfoPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement orginfo;

	public WebElement getOrginfo() {
		return orginfo;
	}

	public WebElement getHeaderVerificationLink() {
		// TODO Auto-generated method stub
		return orginfo;
	}
	
	

}
