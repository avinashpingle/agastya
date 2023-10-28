package com.agastya.stepdefinitions;


import java.util.List;

import org.testng.asserts.SoftAssert;

import com.agastya.base.Keyword;
import com.agastya.pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyntraSteps {
	Keyword keyword = new Keyword();
	
	@Given("Application is launched completely")
	public void launchAppUrl() {
		keyword.launchUrl("https://www.myntra.com");
	}

	@When("User searches Sneakers in search component")
	public void searchProduct() {
		HomePage homepage = new HomePage();
		homepage.searchProduct("Sneaker");
	}
	
	@Then("All results must contain Sneakers word in the product title")
	public void all_results_must_contain_sneakers_word_in_the_product_title() {
		HomePage homepage = new HomePage();
		List<String> productTitles = homepage.getProductTitles();
		SoftAssert softly = new SoftAssert();
		for (String productTitle : productTitles) {
			softly.assertTrue(productTitle.contains("Sneaker"),"Product title: "+productTitle+" doesnt  contain Sneaker");
		}
		softly.assertAll();
	}
}
