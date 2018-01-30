package com.flipkartwebautomation.pages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;

import com.flipkartwebautomation.bean.ProductInfoBean;
import com.flipkartwebautomation.components.ProductComponent;
import com.flipkartwebautomation.utils.CommonUtils;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;


public class SearchresultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchproduct.cmp.productdetails")
	private List<ProductComponent>  searchproductCmpProductdetails;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<ProductComponent> getSearchproductCmpProductdetails() {
		return searchproductCmpProductdetails;
	}
	
	public void verifyProductList()
	{
		Validator.verifyThat(getSearchproductCmpProductdetails().size(), Matchers.greaterThan(0));
		getSearchproductCmpProductdetails().get(0).getSelectproductLinkProductname().waitForVisible();
		
		for(ProductComponent p:getSearchproductCmpProductdetails())
		{
			System.out.println("ProductName is : "+p.getSelectproductLinkProductname().getText());
			System.out.println("ProductPrice is : "+p.getSelectproductLinkProductPrice().getText());
		}
	}
	
	public void selectProductName(int index)
	{
		ProductInfoBean productInfoBean =new ProductInfoBean();
		
		productInfoBean.setProductName(getSearchproductCmpProductdetails().get(index).getSelectproductLinkProductname().getText());
		productInfoBean.setProductPrice(getSearchproductCmpProductdetails().get(index).getSelectproductLinkProductPrice().getText());
		System.out.println("******************************************"+getSearchproductCmpProductdetails().get(index).getSelectproductLinkProductPrice().getText());
		HashMap<String , ProductInfoBean> productInfo=new HashMap<String, ProductInfoBean>();
		productInfo.put(productInfoBean.getProductName(), productInfoBean);
		
		getSearchproductCmpProductdetails().get(index).getSelectproductLinkProductname().click();
		CommonUtils.setProductItem(productInfo);
		QAFTestBase.pause(3000);
	}

}
