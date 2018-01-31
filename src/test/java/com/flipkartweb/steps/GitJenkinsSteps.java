package com.flipkartweb.steps;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.FlipKartMasterModel.UserGeneric;
import com.gitjenkins.LoginBookTicketPage;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class GitJenkinsSteps extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void checkTestOrderFlow()
	
	{   LoginBookTicketPage loginBookTicketPage=new LoginBookTicketPage();
		loginBookTicketPage.lauchsite();
		loginBookTicketPage.clickLoginLink("Indore (IDR)", "Mumbai (BOM)");
		loginBookTicketPage.clickFlightDetails();
		String srcStation=loginBookTicketPage.getDetailsSelectedFlight().get(0);
		String destStation=loginBookTicketPage.getDetailsSelectedFlight().get(1);
        System.out.println(loginBookTicketPage.getDetailsSelectedFlight().get(0));
		System.out.println(loginBookTicketPage.getDetailsSelectedFlight().get(1));
	    Validator.verifyThat(srcStation,Matchers.containsString("IDR"));
	    Validator.verifyThat(destStation,Matchers.containsString("BOM"));
     }

}