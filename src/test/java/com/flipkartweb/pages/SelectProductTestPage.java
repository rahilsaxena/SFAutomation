package com.flipkartweb.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class SelectProductTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "selectproduct.link.productname")
	private QAFWebElement selectproductLinkProductname;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSelectproductLinkProductname() {
		return selectproductLinkProductname;
	}
	
	public void selectProduct(String productName)
	{
		
		QAFExtendedWebElement productCategoryName= new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("selectproduct.link.productname"),productName));
		productCategoryName.waitForVisible();
		Validator.verifyThat("verifySelectProduct page verification",driver.getTitle(),Matchers.containsString("Apple Store | Buy Apple Store at Best Price in India | Flipkart.com"));
		productCategoryName.click();
		
	}
	public void verifySelectProductPage() {
	
		
	}
}
