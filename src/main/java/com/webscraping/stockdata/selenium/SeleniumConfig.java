package com.webscraping.stockdata.selenium;

import org.springframework.stereotype.Service;

@Service
public class SeleniumConfig {
	
	public void seleniumDriver( ){
	System.setProperty(Constants.webdriver,Constants.driverPath);  

	}
}
