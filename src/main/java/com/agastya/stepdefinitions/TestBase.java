package com.agastya.stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.agastya.config.Configuration;
import com.agastya.exceptions.InvalidBrowserNameError;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {

	private static final Logger LOG = Logger.getLogger(TestBase.class);
	public static RemoteWebDriver driver;
	public Configuration config;

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	@Before
	public void setUp() throws MalformedURLException {

		config = new Configuration();
		if (config.getExecutionMode().equalsIgnoreCase("local")) {
			LOG.info("Executing suite on local");
			if(config.getBrowserName().equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}else if(config.getBrowserName().equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}else if(config.getBrowserName().equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
			}else {
				throw new InvalidBrowserNameError(config.getBrowserName());
			}
		} else {
			LOG.info("Executing suite on grid");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("platformName", "Windows");
			firefoxOptions.setCapability("se:name", "My simple test");
			firefoxOptions.setCapability("se:sampleMetadata", "Sample metadata value");

			driver = new RemoteWebDriver(new URL("http://192.168.0.126:4444"), firefoxOptions);
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		LOG.info("All Browsers are closed");
	}
}
