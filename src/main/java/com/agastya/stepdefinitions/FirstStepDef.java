package com.agastya.stepdefinitions;

import org.apache.log4j.Logger;

import com.agastya.base.Keyword;
import com.agastya.config.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FirstStepDef {
	
	private static final Logger LOG= Logger.getLogger(FirstStepDef.class);

	Configuration config = new Configuration();
	Keyword keyword = new Keyword();
	@Given("क्रोम ब्राउज़र खोले")
	public void m1() {
		keyword.openBrowser("Firefox");
	}
	
	@When("एप्लीकेशन की यूआरएल खुलेग")
	public void launchAppUrl() {
		keyword.launchUrl(config.getAppUrl("beta"));
	}
	
}
