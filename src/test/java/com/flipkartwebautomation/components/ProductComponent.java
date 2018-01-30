package com.flipkartwebautomation.components;



import com.qmetry.qaf.automation.ui.annotations.FindBy;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ProductComponent extends QAFWebComponent{

	public ProductComponent(String locator) {
		super(locator);
		
	}
	@FindBy(locator = "searchproduct.lnk.productname")
	private QAFWebElement searchproductLnkProductname;
	
	@FindBy(locator = "searchproduct.lbl.productprice")
	private QAFWebElement searchproductLblProductprice;

	

	public QAFWebElement getSelectproductLinkProductname() {
		return searchproductLnkProductname;
	}
	
	public QAFWebElement getSelectproductLinkProductPrice() {
		return searchproductLblProductprice;
	}

	

	

}
