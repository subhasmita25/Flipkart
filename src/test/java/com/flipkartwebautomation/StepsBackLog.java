/**
 * 
 */
package com.flipkartwebautomation;

import com.flipkartwebautomation.pages.AddToCartPage;
import com.flipkartwebautomation.pages.FlipkarthomeTestPage;
import com.flipkartwebautomation.pages.ProductdetailsTestPage;
import com.flipkartwebautomation.pages.SearchresultTestPage;
import com.flipkartwebautomation.pages.SelectproductTestPage;
import com.qmetry.qaf.automation.step.QAFTestStep;

/**
 * @author Subhasmita.Rout
 */
public class StepsBackLog {
	FlipkarthomeTestPage flipkarthometestpage = new FlipkarthomeTestPage();
	SelectproductTestPage selectproductpage = new SelectproductTestPage();
	SearchresultTestPage searchresultTestPage = new SearchresultTestPage();
	ProductdetailsTestPage productdetailTestPage = new ProductdetailsTestPage();

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user opens flipkart application")
	public void userOpensFlipkartApplication() {
		flipkarthometestpage.lauchSite();
		flipkarthometestpage.verifyFlipkartHomePage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user closes the pop up box")
	public void userClosesThePopUpBox() {
		flipkarthometestpage.crossBttonClick();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects {0} from {1} catagory")
	public void UserSelectsFromCatagory(String subMenu, String menu) {
		flipkarthometestpage.selectCatagory(menu, subMenu);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user navigates to searchproduct")
	public void UserNavigatesToSearchproduct() {

		selectproductpage.verifySelectProductPage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects {0} from searchproduct list")
	public void userSelectsFromSearchproductList(String productCatagory) {
		selectproductpage.selectProduct(productCatagory);

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user navigates to searchproduct page")
	public void userNavigatesToSearchproductPage() {
		searchresultTestPage.verifyProductList();

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects {0} product from product list")
	public void userSelectsProductFromProductList(String index) {
		searchresultTestPage.selectProductName(Integer.parseInt(index));

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user verifies product details matching correctly")
	public void userVerifiesProductDetailsMatchingCorrectly() {
		productdetailTestPage.verifyProductOnDetailPage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects addtoCart button")
	public void userSelectsAddtoCartButton() {
		productdetailTestPage.selectAddToCartButton();

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "product has been added to cart")
	public void productHasBeenAddedToCart() {
		AddToCartPage addToCartPage =new AddToCartPage();
		addToCartPage.verifyProductOnAddToCartPage();
	}

}
