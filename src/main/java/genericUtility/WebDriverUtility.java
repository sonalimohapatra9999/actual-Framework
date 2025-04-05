package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is consist of DropDown, browser related actions, actions ,Popup
 */

public class WebDriverUtility {
	/**
	 * This method is used to Maximize the browser
	 * @param driver
	 */
	
	public void tomaximize(WebDriver driver) {
	driver.manage().window().maximize();
	
}
/**
 * This method is used to minimize the browser
 * @param driver
 */

public void tominimize(WebDriver driver) {
	driver.manage().window().minimize();
}

/**
 * This method is wait until the element is looked in the webpage(implicit wait)
 *@param driver 
 */

public void toWaitForElements(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}

/**
 * This method is wait until the element is clickable provided driver and element
 * until the condition is satisfied(explicit wait)
 * 
 * @param driver
 * @param element
 */

public void toWaitUntilElementClickable(WebDriver driver, WebElement element) {
	WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}

/**
 * This method will wait until the element is visible provided driver and element
 * @param driver
 * @param element
 */

public void toWaitUntilElementVisibilityOfElement(WebDriver driver, WebElement element) {
	WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**This method is used to handle dropdown using index
 * @param element
 * @param index
 */


public void toHandleDropdown(WebElement element, int index) {
	Select select = new Select(element);
	select.selectByIndex(index);
}

/**This method is used to handle dropdown using value
 * @param element
 * @param value
 */
public void toHandleDropdown(WebElement element,String value) {
	Select select = new Select(element);
	select.selectByValue(value);
	
	
}


/**
 * This method is used to handle dropdown using visible text
 * @param text
 * @param element
 */

public void toHandleDrpdown(String text,WebElement element) {
	Select select = new Select(element);
	select.selectByVisibleText(text);
}

/**
 * this method is used to perform mouse action provided driver and element
 * @param driver
 * @param element
 */

public void toMouseHover(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	
}

/**
 * this method is used to perform right click provided driver and element
 *@param driver
 *@param element
 */


public void toRightClick(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.contextClick(element).perform();
}


/**
 * this method is used to perform double click provided driver and element
 * @param driver
 * @param element
 */


public void toDoubleClick(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.doubleClick(element).perform();
}

/**
 * this method is used to perform drag and drop provided driver and webelements
 * @param driver
 * @param src
 * @param target
 */

public void toDragAndDrop(WebDriver driver,WebElement src,WebElement target) {
	Actions action = new Actions(driver);
	action.dragAndDrop(src, target).perform();
	
	
}

/**
 * this method is used to handle frame using index
 * @param driver
 * @param index
 */

public void toHandleFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
/**
 * this method is used to handle frame using id or name
 * @param driver
 * @param name_id
 */
public void toHandleFrame(WebDriver driver, String name_id) {
	driver.switchTo().frame(name_id);
}

/**
 * this method is used to handle frame using webelement
 * @param driver
 * @param element
 */
public void toHandleFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * This method is used to switch back from home 
 * @param driver
 */


public void toHandleFrame(WebDriver driver) { 
	driver.switchTo().defaultContent();
}

/**
 * this message is used to handle alert popup by accepting it
 * @param driver
 */
public void toSwitchToAlertAndAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
	
}
/**
 * this method is used to handle alert popup by dismissing it
 * @param driver
 * 
 * 
 */

public void toSwitchAlertAndDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}

/**
 * This method is used to capture text in alert popup and accept it
 * @param driver
 * @return
 */

public String toSwitchToAlertAndCaptureMessage(WebDriver driver) {
	Alert alertpopup = driver.switchTo().alert();
	String message = alertpopup.getText();
	 alertpopup.accept();
    return message;
	
}
/**
 * this method is used to take screenshot provideddriver and screenshotname
 * @param driver
 * @param screenshotname
 * @throws IOException
 */

public void toTakeScreenshot(WebDriver driver, String screenshotname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File src = new File("./errorShots/"+ screenshotname +".png");
	FileHandler.copy(temp, src);
	
}
/**
 * This method is used to switch the driver control to window
 * @param driver
 * @param partialTitle
 */
public void toSwitchWindow(WebDriver driver, String partialTitle) {
	Set<String> allIds = driver.getWindowHandles();
	for(String id : allIds) {
		String title = driver.switchTo().window(id).getTitle();
		if(title.contains(partialTitle)) {
			break;
		}
	}
}










	

	
	

}
