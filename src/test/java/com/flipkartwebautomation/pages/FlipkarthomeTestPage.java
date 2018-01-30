package com.flipkartwebautomation.pages;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class FlipkarthomeTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "homepage.link.menuname")
	private QAFWebElement homepageLinkMenuname;
	@FindBy(locator = "homepage.link.submenu")
	private QAFWebElement homepageLinkSubmenu;

	@FindBy(locator = "cross.button")
	private QAFWebElement crossButton;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getHomepageLinkMenuname() {
		return homepageLinkMenuname;
	}

	public QAFWebElement getHomepageLinkSubmenu() {
		return homepageLinkSubmenu;
	}
	public QAFWebElement getCrossButton() {
		return crossButton;
	}
	
	public void crossBttonClick()
	{
		QAFExtendedWebElement xButtonname= new QAFExtendedWebElement(
				String.format(ConfigurationManager.getBundle().getString("cross.button")));
		xButtonname.waitForVisible();
		
		xButtonname.click();
		QAFTestBase.pause(3000);
		
	}
	public void selectCatagory(String menuname,String submenu)
	{
		
		
		
		QAFExtendedWebElement catagoryname= new QAFExtendedWebElement(
		String.format(ConfigurationManager.getBundle().getString("homepage.link.menuname"), menuname));
		
		Actions actions= new Actions(driver);
		actions.moveToElement(catagoryname).perform();
		
		catagoryname.waitForVisible(5000);
		
		QAFExtendedWebElement subcatagoryname= new QAFExtendedWebElement(
		String.format(ConfigurationManager.getBundle().getString("homepage.link.submenu"), submenu));
		
		subcatagoryname.waitForVisible();
		subcatagoryname.click();
	}
	
	public void lauchSite()
	{
		driver.get("/");
	}
	public void verifyFlipkartHomePage()
	{
		Validator.verifyThat("Flipkart home page verification", driver.getTitle(),Matchers.containsString("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"));
		
	}

}
