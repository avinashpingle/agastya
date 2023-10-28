package com.agastya.utilities;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", 
glue = "com.agastya.stepdefinitions")
public class FeatureRunner extends AbstractTestNGCucumberTests{

	
}
