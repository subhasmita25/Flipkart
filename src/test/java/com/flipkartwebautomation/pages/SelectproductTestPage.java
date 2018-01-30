package com.flipkartwebautomation.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class SelectproductTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "selectproduct.link.productname")
	private QAFWebElement selectproductLinkProductname;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSelectproductLinkProductname() {
		return selectproductLinkProductname;
	}
	
public void verifySelectProductPage() {
		
		//Validator.verifyThat("verifySelectProduct Page verification", driver.getTitle(),Matchers.containsString("Apple Store | Buy Apple Store at Best Price in India | Flipkart.com"));

		
	}
	
	
	
	public void selectProduct(String productname) {
		
		QAFExtendedWebElement productCatagoryname= new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("selectproduct.link.productname"), productname));
		productCatagoryname.waitForVisible();
		Validator.verifyThat("verifySelectProduct Page verification", driver.getTitle(),Matchers.containsString("Apple Store | Buy Apple Store at Best Price in India | Flipkart.com"));
		productCatagoryname.click();
		
		
		
	}

}
