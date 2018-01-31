package com.gitjenkins;

import java.util.ArrayList;
import java.util.List;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class LoginBookTicketPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		
	}
	public void lauchsite() {
		driver.get("/");
		driver.manage().window().maximize();
}
	 @FindBy(locator = "src.point")
	 private QAFWebElement SrcPoint;
	 
	 @FindBy(locator = "dest.point")
	 private QAFWebElement DestPoint;
	 
	 @FindBy(locator = "submit.btn")
	 private QAFWebElement SubmitButton;
	 
	 @FindBy(locator = "calender.icon")
	 private QAFWebElement CalenderIcon;
	
	 
	 @FindBy(locator = "select.date")
	 private QAFWebElement SelectDate;
	 
	 @FindBy(locator = "one.way")
	 private QAFWebElement OneWay;
	 
	 @FindBy(locator = "flight.details")
	 private QAFWebElement FlightDetails;
	 
	 //a i.icon-swap.ico36.fl.txtCenter.white
	 @FindBy(locator = "Swap.Icon")
	 private QAFWebElement SwapIcon;
	 
	 
	 @FindBy(locator = "verify.details")
	 private List<QAFWebElement> VerifyDetails;

	 public void clickLoginLink(String srcpoint,String destpoint) {
		// OneWay.click();
		 QAFTestBase.pause(5000);
		
		 SrcPoint.sendKeys(srcpoint);
		 QAFTestBase.pause(1000);

		 DestPoint.sendKeys(destpoint);
		 QAFTestBase.pause(1000);

		 CalenderIcon.click();
		 QAFTestBase.pause(1000);

		 SelectDate.click();
		 QAFTestBase.pause(1000);

		 SubmitButton.click();  
		 QAFTestBase.pause(5000);
	 }
	 
	 public void clickFlightDetails() {
         FlightDetails.click();

	 }
	 
	 
	 public List<String> getDetailsSelectedFlight() {
		 QAFTestBase.pause(1000);
		 ArrayList<String> al=new ArrayList<String>();
	     al.add(VerifyDetails.get(0).getText());
	     al.add(VerifyDetails.get(1).getText());
	     return al;

	 }
}