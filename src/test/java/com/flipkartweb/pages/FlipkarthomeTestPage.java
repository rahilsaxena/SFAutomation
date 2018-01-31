package com.flipkartweb.pages;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlipkarthomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "homePage.link.menuname")
	private QAFWebElement homePageLinkMenuname;
	@FindBy(locator = "homePage.link.submenuname")
	private QAFWebElement homePageLinkSubmenuname;
	@FindBy(locator = "loginpage.closebutton")
	private QAFWebElement loginPageCloseButton;
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getHomePageLinkMenuname() {
		return homePageLinkMenuname;
	}

	public QAFWebElement getHomePageLinkSubmenu() {
		return homePageLinkSubmenuname;
	}
	public QAFWebElement getLoginPageCloseButton() {
		return loginPageCloseButton;
	}
	
	
	
	public void selectCategory(String subMenuName, String mainMenuName) 
	{   QAFTestBase.pause(5000);
		QAFExtendedWebElement categoryName= new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("homePage.link.menuname"),mainMenuName));
		Actions actions= new Actions(driver);
		actions.moveToElement(categoryName).perform();
				
		QAFExtendedWebElement subCategoryName= new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("homePage.link.submenuname"),subMenuName));
	
		subCategoryName.waitForVisible();
		subCategoryName.click();
		
	}
	
	public void lauchsite() {
		driver.get("/");
}
	public void verifyFlipKartHomePage() {
		Validator.verifyThat("FlipKartHomePage verification",driver.getTitle(),Matchers.containsString("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"));

	}
	
	public void closeLoginPopup()
	{
		if(loginPageCloseButton.isPresent()&&loginPageCloseButton.isDisplayed())
		{
		loginPageCloseButton.click();
		}
		}
}
