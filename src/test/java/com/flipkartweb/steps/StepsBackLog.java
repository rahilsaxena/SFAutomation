
package com.flipkartweb.steps;

import org.hamcrest.Matchers;
import com.FlipKartMasterModel.UserGeneric;
import com.flipkartweb.pages.AddToCartPage;
import com.flipkartweb.pages.FlipkartCommonServices;
import com.flipkartweb.pages.FlipkartLoginPage;
import com.flipkartweb.pages.FlipkarthomeTestPage;
import com.flipkartweb.pages.ProductdetailTestPage;
import com.flipkartweb.pages.SearchresultTestPage;
import com.flipkartweb.pages.SelectProductTestPage;
import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.Validator;

/**
 * @author Rahil.saxena
 */
public class StepsBackLog {


	SelectProductTestPage productTestPage = new SelectProductTestPage();
	SearchresultTestPage searchresultTestPage = new SearchresultTestPage();
	ProductdetailTestPage productdetailTestPage = new ProductdetailTestPage();
	AddToCartPage addToCartPage = new AddToCartPage();
	FlipkarthomeTestPage flipkarthomeTestPage = new FlipkarthomeTestPage();
	FlipkartCommonServices flipkartCommonServices=new FlipkartCommonServices();


	@QAFTestStep(description = "user select {0}  from {1} category")
	public void userSelectFromCategory(String subMenuName, String menuName) {
		flipkarthomeTestPage.selectCategory(subMenuName, menuName);
	}

	
	@QAFTestStep(description = "user applies hiereacy filter an compare count value")
	public void userAppliesHiereacyFilterAnCompareCountValue() {
		flipkartCommonServices.validateCountOfItemAfterHierarchyFilter();

	}
	

	@QAFTestStep(description = "user select {0}  product from product list")
	public void userSelectProductFromProductList() {
	    flipkartCommonServices.clickAnyItem();

	}
	
	@QAFTestStep(description = "user verifies product details matching correctly")
	public void userVerifiesProductDetailsMatchingCorrectly() {
		String itemRaitngInList=flipkartCommonServices.getItemRating();
		String itemRaitngInItemDesc=flipkartCommonServices.getItemRating();
//Validate value of meta data i.e. Name
	    Validator.verifyThat(flipkartCommonServices.getMetadata(),Matchers.containsString(productdetailTestPage.getProductdetailLblProductname().getText()));
//Validate value of meta data i.e. Rating
		Validator.verifyThat(itemRaitngInList,Matchers.containsString(itemRaitngInItemDesc));
		    	}
	
	
	@QAFTestStep(description = "user change pin code and verify")
	public void userChangePinCodeAndVerify() {
	    flipkartCommonServices.setAndCheckpincode();
	}


	@QAFTestStep(description = "user get delivery date time")
	public void userGetDeliveryDateTime() {
		flipkartCommonServices.getDeleieveyDatetime();  
	}


	@QAFTestStep(description = "user click on view detail")
	public void userClickOnViewDetail() {
		flipkartCommonServices.clickViewDetailBtn();
	}

	
	@QAFTestStep(description = "user verifies delivery date time and fassured item")
	public void userVerifiesDeliveryDateTimeAndFassuredItem() {
		 String deliveryDateTimeiInProduct=flipkartCommonServices.getDeleieveyDatetime();
			flipkartCommonServices.clickViewDetailBtn();
			String deliveryDateTimeiInViewDetail=flipkartCommonServices.getDeleieveyDatetime();    
		    Validator.verifyThat(deliveryDateTimeiInProduct,Matchers.containsString(deliveryDateTimeiInViewDetail));
		    Validator.verifyThat(flipkartCommonServices.fAssuredTextInViewDetail(),Matchers.containsString(UserGeneric.fAssured));

	}
	
	@QAFTestStep(description = "user select add to cart")
	public void userSelectAddToCart() {
		productdetailTestPage.addToCartButton();

	}
	@QAFTestStep(description = "product has been added to cart")
	public void productHasBeenAddedToCart() {
		addToCartPage.isItemExistAtCart();
	}
	@QAFTestStep(description = "user place order")
	public void userPlaceOrder() {
		addToCartPage.placeOrder();

	}
	
	@QAFTestStep(description = "order place and user verifies user detail in same page")
	public void orderPlaceAndUserVerifiesUserDetailInSamePage() {
		Validator.verifyThat(addToCartPage.getUserdetail(),Matchers.containsString(UserGeneric.Username));

	}

}
