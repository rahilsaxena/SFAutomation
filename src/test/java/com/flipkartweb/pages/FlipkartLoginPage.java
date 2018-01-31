package com.flipkartweb.pages;

import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FlipkartLoginPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	 @FindBy(locator = "login.link")
		private QAFWebElement loginLink;
	 //input._2zrpKA _3v41xv
	 @FindBy(locator = "logout.link")
	 private QAFWebElement logoutLink;
	 @FindBy(locator = "login.user.name")
	 private QAFWebElement loginUserName;
	 @FindBy(locator = "login.password")
	 private QAFWebElement loginPassword;
	 @FindBy(locator = "login.Button")
	 private QAFWebElement loginButton;
	 
	 public void clickLoginLink(String username,String Password) {
		 loginUserName.sendKeys(username);
		 loginPassword.sendKeys(Password);
		 loginButton.click();
       
	 }
	 public void clickLogout() {
		
        Actions actions= new Actions(driver);
		actions.moveToElement(loginLink);
		logoutLink.click();
		
	 }
	 public String getLoginUserName() {
		 String username=loginLink.getTagName();
		 System.out.println(username);
		 return username;
	 }
	
}