package com.flipkartweb.pages;


import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;
import org.hamcrest.*;
import java.util.*;

import com.flipkartweb.beans.ProductInfoBean;
import com.flipkartweb.components.ProductComponent;
import com.flipkartweb.utils.CommonUtils;

public class SearchresultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	@FindBy(locator="searchproduct.cmp.productdetails")
	private List<ProductComponent>  searchproductCmpProductdetails;
	
	public List<ProductComponent>  getSearchproductCmpProductdetails(){
		return searchproductCmpProductdetails;
	}
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	public void verifyProductList() {
		Validator.verifyThat(searchproductCmpProductdetails.size(), Matchers.greaterThan(0));
		getSearchproductCmpProductdetails().get(0).getSearchproductLinkProductname().waitForVisible();
		
		for (ProductComponent p:getSearchproductCmpProductdetails() )
		{
			System.out.println("ProductName"+p.getSearchproductLinkProductname());
			System.out.println("ProductName"+p.getSearchproductLblProductprice());

		}
		
		}
	
	public void selectProductName(int index) {
		getSearchproductCmpProductdetails().get(index).getSearchproductLinkProductname().click();
		ProductInfoBean productInfoBean=new ProductInfoBean();
		productInfoBean.setProductName(getSearchproductCmpProductdetails().get(index).getSearchproductLinkProductname().getText());
		//productInfoBean.setProductPrice(getSearchproductCmpProductdetails().get(index).getSearchproductLblProductprice().getText());
		HashMap<String, ProductInfoBean> productInfo= new HashMap<String, ProductInfoBean>();
		productInfo.put(productInfoBean.productName, productInfoBean);
		CommonUtils.setProductItem(productInfo);
		QAFTestBase.pause(10000);

	}
	

}
