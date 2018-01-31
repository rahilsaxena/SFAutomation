package com.flipkartweb.pages;

import java.util.HashMap;

import org.hamcrest.Matchers;

import com.flipkartweb.beans.ProductInfoBean;
import com.flipkartweb.utils.CommonUtils;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductdetailTestPage extends  WebDriverBaseTestPage<WebDriverTestPage>{

	@FindBy(locator = "productdetail.lbl.productname")
	private QAFWebElement productdetailLblProductname;
	
    @FindBy(locator = "productdetail.lbl.price")
	private QAFWebElement productdetailLblPrice;
	
	@FindBy(locator = "productdetail.btn.addtocart")
	private QAFWebElement addtoCartButton;
	
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	public QAFWebElement getProductdetailLblProductname() {
		return productdetailLblProductname;
	}

	public QAFWebElement getProductdetailLblPrice() {
		return productdetailLblPrice;
	}

	public void verifyProductOnDetailPage() {
		if(driver.getWindowHandles().size()>1) {
			CommonUtils.switchToWindow(driver);
		}
		getProductdetailLblProductname().waitForVisible();
	    HashMap<String, ProductInfoBean>  productInfo2=CommonUtils.getProductItems();
	    for (String key:productInfo2.keySet()) {
	    	ProductInfoBean details=productInfo2.get(key);
	    	Validator.verifyThat(getProductdetailLblProductname().getText(), Matchers.containsString(details.getProductName()));
	    	System.out.println(getProductdetailLblPrice().getText());
	    	System.out.println(Matchers.containsString(details.getProductPrice()));
            //Validator.verifyThat(getProductdetailLblPrice().getText(),Matchers.containsString(details.getProductPrice()));
            QAFTestBase.pause(5000);
	    }
	}
	public void addToCartButton() {
		
		addtoCartButton.click();
	}
}
