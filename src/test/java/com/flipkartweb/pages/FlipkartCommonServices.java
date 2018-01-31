package com.flipkartweb.pages;

import java.util.List;

import org.hamcrest.Matchers;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlipkartCommonServices extends  WebDriverBaseTestPage<WebDriverTestPage>{
	
	@FindBy(locator = "check.box.assured")
	private List<QAFWebElement> checkBoxAssured;
	
	@FindBy(locator = "listItemAfter.search")
	private List<QAFWebElement> listItemAfterSearch;
	
	@FindBy(locator = "count.after.assured.filter")
	private QAFWebElement countAfterAssuredFilter;
	
	@FindBy(locator = "product.name.in.meta.data")
	private QAFWebElement productNameInMetaData;
	
	@FindBy(locator = "view.detail.btn")
	private QAFWebElement viewDetailBtn;
	
    @FindBy(locator = "pin.code")
	private QAFWebElement pinCode;

	@FindBy(locator = "day.time.for.item")
	private QAFWebElement dayTimeForItem;
	
	@FindBy(locator = "check.pin.code")
	private QAFWebElement checkPinCode;
	
	@FindBy(locator = "item.rating")
	private QAFWebElement itemRating;

	@FindBy(locator = "fassured.content.view.detail")
	private List<QAFWebElement> fAssuredContentViewDetail;
	
	
    @Override
    protected void openPage(PageLocator locator, Object... args) {
	// TODO Auto-generated method stub
	
           }

    public boolean validateCountOfItemAfterHierarchyFilter() {
    	//Apply assured filter 
	    checkBoxAssured.get(0).click();
		QAFTestBase.pause(10000);
		int a=Integer.parseInt(getAssuredFilterValue().substring(28, 33).replace(",", ""));
		System.out.println(a);
		QAFTestBase.pause(5000);
    	//Apply brand filter 
        checkBoxAssured.get(1).click();
		int b=Integer.parseInt(getAssuredFilterValue().substring(28, 30).replace(",", ""));
		System.out.println(b);
		//Validating value after filters
		Validator.verifyThat(a, Matchers.greaterThan(b));

		if(a>=b)
	    {
		   return true;
	    }
	   return false;
	}
	
    
	public String getAssuredFilterValue() {
		QAFTestBase.pause(10000);
		
        return countAfterAssuredFilter.getText();

	}
	
	public void selectBrandFromCheckBox() {
		QAFTestBase.pause(10000);
		
		}

	public String getMetadata() {
		return productNameInMetaData.getAttribute("title");
	}

	public void clickAnyItem() {
		QAFTestBase.pause(5000);
		 listItemAfterSearch.get(0).click();
		}

	public void setAndCheckpincode() {
		QAFTestBase.pause(2000);
		pinCode.clear();
		pinCode.sendKeys("560034");
		checkPinCode.click();
	}
	public String getDeleieveyDatetime() {
		return dayTimeForItem.getText();
	}
	public void clickViewDetailBtn() {
		QAFTestBase.pause(5000);
		viewDetailBtn.click();
	}
	
	public String getItemRating() {
		return itemRating.getText();
	}
	
	public String fAssuredTextInViewDetail() {
		return fAssuredContentViewDetail.get(1).getText();
	}
}

