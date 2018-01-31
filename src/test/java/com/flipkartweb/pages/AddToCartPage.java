package com.flipkartweb.pages;



import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AddToCartPage  extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@FindBy(locator = "productdetail.addtocart.data")
	private QAFWebElement materailplaced;
	
	@FindBy(locator = "placed.order")
	private QAFWebElement placedorder;
	
	
	@FindBy(locator = "user.details")
	private QAFWebElement userdetails;
	
	 

@Override
protected void openPage(PageLocator locator, Object... args) {
	// TODO Auto-generated method stub
	
           }
	
public boolean isItemExistAtCart() {
	{
	materailplaced.isDisplayed();
	return true;
                       }
	}

public void placeOrder() {
		placedorder.click();
		
		
		}
public String getUserdetail() {
	return userdetails.getText();
        }

}


