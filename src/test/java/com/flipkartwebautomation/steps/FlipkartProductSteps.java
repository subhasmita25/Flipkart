package com.flipkartwebautomation.steps;

import org.testng.annotations.Test;

import com.flipkartwebautomation.pages.AddToCartPage;
import com.flipkartwebautomation.pages.FlipkarthomeTestPage;
import com.flipkartwebautomation.pages.ProductdetailsTestPage;
import com.flipkartwebautomation.pages.SearchresultTestPage;
import com.flipkartwebautomation.pages.SelectproductTestPage;

public class FlipkartProductSteps {
	
	
	

	@Test
	public void checkTestOderFlow()
	{
		FlipkarthomeTestPage flipkarthometestpage=new FlipkarthomeTestPage();
		flipkarthometestpage.lauchSite();
		flipkarthometestpage.verifyFlipkartHomePage();
		flipkarthometestpage.crossBttonClick();
		flipkarthometestpage.selectCatagory("Electronics", "Apple");
		
	
		SelectproductTestPage selectproductpage=new SelectproductTestPage();
		selectproductpage.verifySelectProductPage();
		selectproductpage.selectProduct("iPad");
		
		SearchresultTestPage searchresultTestPage =new SearchresultTestPage();
		searchresultTestPage.verifyProductList();
		searchresultTestPage.selectProductName(0);
		
		ProductdetailsTestPage productdetailTestPage =new ProductdetailsTestPage();
		productdetailTestPage.verifyProductOnDetailPage();
		productdetailTestPage.selectAddToCartButton();
		
		AddToCartPage addToCartPage =new AddToCartPage();
		addToCartPage.verifyProductOnAddToCartPage();
	}
		
}
