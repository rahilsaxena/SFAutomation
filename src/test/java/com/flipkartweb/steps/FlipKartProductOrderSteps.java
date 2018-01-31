package com.flipkartweb.steps;

import org.testng.annotations.Test;

import com.flipkartweb.pages.AddToCartPage;
import com.flipkartweb.pages.FlipkarthomeTestPage;
import com.flipkartweb.pages.ProductdetailTestPage;
import com.flipkartweb.pages.SearchresultTestPage;
import com.flipkartweb.pages.SelectProductTestPage;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;


public class FlipKartProductOrderSteps extends WebDriverBaseTestPage<WebDriverTestPage> {
	
	@Test
	public void checkTestOrderFlow()
	{
		FlipkarthomeTestPage flipkarthomeTestPage= new FlipkarthomeTestPage();
		flipkarthomeTestPage.lauchsite();
		flipkarthomeTestPage.verifyFlipKartHomePage();
		flipkarthomeTestPage.closeLoginPopup();
		flipkarthomeTestPage.selectCategory("Electronics","Apple");
		SelectProductTestPage productTestPage= new SelectProductTestPage();
		//productTestPage.verifySelectProductPage();
		productTestPage.selectProduct("Mac");
		SearchresultTestPage searchresultTestPage=new SearchresultTestPage();
		searchresultTestPage.verifyProductList();
		searchresultTestPage.selectProductName(0);
		ProductdetailTestPage productdetailTestPage= new ProductdetailTestPage();
		productdetailTestPage.verifyProductOnDetailPage();
		productdetailTestPage.addToCartButton();
		AddToCartPage addToCartPage= new AddToCartPage();
		addToCartPage.isItemExistAtCart();
		
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	

}