package com.flipkartweb.components;


import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductComponent  extends QAFWebComponent{
	
	
	public  ProductComponent(String locator) {
    super(locator)	;
}
	
	@FindBy(locator = "searchproduct.lnk.productname")
	private QAFWebElement searchproductLinkProductname;
	@FindBy(locator = "searchproduct.lbl.productprice")
	private QAFWebElement searchproductLblProductprice;
	
	public QAFWebElement getSearchproductLinkProductname() {
		return searchproductLinkProductname;
	}
	public QAFWebElement getSearchproductLblProductprice() {
		return searchproductLblProductprice;
	}
}
