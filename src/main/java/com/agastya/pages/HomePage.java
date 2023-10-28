package com.agastya.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.agastya.base.Keyword;
import com.agastya.stepdefinitions.TestBase;
import com.agastya.utilities.WaitFor;


public class HomePage {
	
	private static final Logger LOG= Logger.getLogger(HomePage.class);

	@FindBy(css = "input[placeholder=\"Search for products, brands and more\"]")
	WebElement searchComponent; // null

	@FindBy(css = "div.storefront-sorting+ul.products>li:nth-child(1)>a.add_to_cart_button")
	WebElement addToCartBtn;

	@FindBy(css = "h4.product-product")
	List<WebElement> productTitles;
	
	

	public HomePage() {
		PageFactory.initElements(TestBase.getDriver(), this);
	}
	
	
	public void searchProduct(String productName) {
		searchComponent.sendKeys(productName);
		searchComponent.sendKeys(Keys.RETURN);
		LOG.info("Entered the product name " + productName + " to search");
	}

	public void clickOnAddToCartBtn() {
		addToCartBtn.click();
	}

	public List<String> getProductTitles() {
		Keyword keyword = new Keyword();
		By productTitle = By.cssSelector("h4.product-product");
		WaitFor.elementToBePresentInList(productTitle);
		return keyword.getTexts(productTitles);
	}

}
