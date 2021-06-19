package com.webscraping.stockdata.common;

import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
public class CompanySymbol {
@Bean
public List<String> getCompnyList(){
	return Arrays.asList(
	  "RELIANCE",
			"TCS",
			"HINDUNILVR",
			"HDFCBANK",
			"HDFC",
			"INFY",
			"KOTAKBANK",
			"BHARTIARTL",
			"ITC",
			"ICICIBANK",
			"SBIN",
			"ASIANPAINT"
);
}
}
