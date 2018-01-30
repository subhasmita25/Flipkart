package com.flipkartwebautomation.pages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.flipkartwebautomation.bean.ProductInfoBean;
import com.flipkartwebautomation.components.ProductComponent;
import com.flipkartwebautomation.utils.CommonUtils;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class AddToCartPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchproduct.cmp.productdetails")
	private List<ProductComponent>  searchproductCmpProductdetails;
	@FindBy(locator = "searchproduct.lnk.productname")
	private QAFWebElement searchproductLnkProductname;
	@FindBy(locator = "searchproduct.lbl.productprice")
	private QAFWebElement searchproductLblProductprice;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<ProductComponent> getSearchproductCmpProductdetails() {
		return searchproductCmpProductdetails;
	}
	public QAFWebElement getSearchproductLnkProductname() {
		return searchproductLnkProductname;
	}

	public QAFWebElement getSearchproductLblProductprice() {
		return searchproductLblProductprice;
	}
	
	public void verifyProductOnAddToCartPage()
	{
		Validator.verifyThat(getSearchproductCmpProductdetails().size(), Matchers.greaterThan(0));
		getSearchproductCmpProductdetails().get(0).getSelectproductLinkProductname().waitForVisible();
		
		HashMap<String, ProductInfoBean> productInfo3 = CommonUtils.getProductItems();
		for (String key : productInfo3.keySet()) {
			ProductInfoBean details = productInfo3.get(key);

			for(ProductComponent productComponent:searchproductCmpProductdetails)
			{
				
				Validator.verifyThat(productComponent.getSelectproductLinkProductname().getText(), Matchers.containsString(details.getProductName()));
				Validator.verifyThat(productComponent.getSelectproductLinkProductPrice().getText(), Matchers.containsString(details.getProductPrice()));
				
			}
		}
		
	}

}
