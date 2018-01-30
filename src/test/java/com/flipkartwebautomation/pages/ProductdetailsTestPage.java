package com.flipkartwebautomation.pages;

import java.util.HashMap;

import org.hamcrest.Matchers;

import com.flipkartwebautomation.bean.ProductInfoBean;
import com.flipkartwebautomation.utils.CommonUtils;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "productdetails.name")
	private QAFWebElement productdetailsName;
	@FindBy(locator = "productdetails.price")
	private QAFWebElement productdetailsPrice;
	@FindBy(locator = "product.detail.addToCart")
	private QAFWebElement productDetailAddToCart;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProductdetailsName() {
		return productdetailsName;
	}

	public QAFWebElement getProductdetailsPrice() {
		return productdetailsPrice;
	}

	public QAFWebElement getProductDetailAddToCart() {
		return productDetailAddToCart;
	}
	
	public void verifyProductOnDetailPage() {
		if(driver.getWindowHandles().size()>1)
			{
				CommonUtils.switchToWindow(driver);
			}
		getProductdetailsName().waitForVisible();
		HashMap<String, ProductInfoBean> productInfos = CommonUtils.getProductItems();
		for(String key: productInfos.keySet())
		{
			ProductInfoBean details = productInfos.get(key);
			Validator.verifyThat(getProductdetailsName().getText(), Matchers.containsString(details.getProductName()));
			
			System.out.println("--------------------------------------"+getProductdetailsPrice().getText());
			System.out.println("+++++++++++++++++++++++++++++++"+details.getProductPrice());
			Validator.verifyThat(getProductdetailsPrice().getText(), Matchers.containsString(details.getProductPrice()));
		}
		}
		public void selectAddToCartButton() {
			getProductDetailAddToCart().click();
			QAFTestBase.pause(5000);
			

		}

}
