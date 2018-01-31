package com.flipkartweb.steps;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.flipkartweb.pages.FlipkarthomeTestPage;
import com.FlipKartMasterModel.UserGeneric;
import com.flipkartweb.pages.AddToCartPage;
import com.flipkartweb.pages.FlipkartCommonServices;
import com.flipkartweb.pages.FlipkartLoginPage;
import com.flipkartweb.pages.ProductdetailTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class NewScenerio {
	@Test
	public void checkTestOrderFlow()
	{

	FlipkarthomeTestPage flipkarthomeTestPage= new FlipkarthomeTestPage();
	flipkarthomeTestPage.lauchsite();
	flipkarthomeTestPage.verifyFlipKartHomePage();
    FlipkartLoginPage flipkartLoginPage= new FlipkartLoginPage();
	
//login from user taking data master model 
    
	flipkartLoginPage.clickLoginLink(UserGeneric.Username,UserGeneric.Password);
	flipkarthomeTestPage.selectCategory("Exercise & Fitness","Books & More");
	FlipkartCommonServices flipkartCommonServices=new FlipkartCommonServices();
	
//Validating count value deceases in subsequent filter by service validateCountOfItemAfterHierarchyFilter
	flipkartCommonServices.validateCountOfItemAfterHierarchyFilter();
	System.out.println(flipkartCommonServices.getMetadata());
	String itemRaitngInList=flipkartCommonServices.getItemRating();
    flipkartCommonServices.clickAnyItem();
	String itemRaitngInItemDesc=flipkartCommonServices.getItemRating();
    ProductdetailTestPage productdetailTestPage= new ProductdetailTestPage();
    
//Validate value of meta data i.e. Name
    Validator.verifyThat(flipkartCommonServices.getMetadata(),Matchers.containsString(productdetailTestPage.getProductdetailLblProductname().getText()));
   
//Validate value of meta data i.e. Rating
    Validator.verifyThat(itemRaitngInList,Matchers.containsString(itemRaitngInItemDesc));
    
//Set and check for pin code
    flipkartCommonServices.setAndCheckpincode();
    String deliveryDateTimeiInProduct=flipkartCommonServices.getDeleieveyDatetime();
	flipkartCommonServices.clickViewDetailBtn();
	String deliveryDateTimeiInViewDetail=flipkartCommonServices.getDeleieveyDatetime();    
//Validating date time in both page	 item and view detail page
    Validator.verifyThat(deliveryDateTimeiInProduct,Matchers.containsString(deliveryDateTimeiInViewDetail));
    
//Validate In view detail it is Assured or not
    Validator.verifyThat(flipkartCommonServices.fAssuredTextInViewDetail(),Matchers.containsString(UserGeneric.fAssured));
    flipkarthomeTestPage.closeLoginPopup();
	AddToCartPage addToCartPage= new AddToCartPage();
	addToCartPage.isItemExistAtCart();
	
//PLacing order 
	addToCartPage.placeOrder();
	
//validating login from same user
	Validator.verifyThat(addToCartPage.getUserdetail(),Matchers.containsString(UserGeneric.Username));
		
	}
}
