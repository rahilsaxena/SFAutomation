package com.flipkartweb.pages;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.automation.step.CommonStep.getText;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class FlipkartLoginPage  {

	@QAFTestStep(description = "user open flipkart application from authenticate user")

	 public void clickLoginLink(String username,String Password) {
		get("/");
		sendKeys(username, "login.user.name");
		 sendKeys(Password,"login.password");
		 click("login.Button");
		
       
	 }
	 public void clickLogout() {
		
        Actions actions= new Actions(new WebDriverTestBase().getDriver());
		actions.moveToElement(new QAFExtendedWebElement("login.link"));
		 click("logout.link");
		
	 }
	 public String getLoginUserName() {
		 String username=getText("login.link");
		 return username;
	 }
	
}