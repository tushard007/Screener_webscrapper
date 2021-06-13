package com.webscraping.stockdata.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webscraping.stockdata.common.CompanySymbol;
import com.webscraping.stockdata.entity.ScreenerBalanceSheetEntity;
import com.webscraping.stockdata.selenium.ScreenerBalenceSheetParser;

@Controller
public class ScreenerBalenceSheetController extends ScreenerBalenceSheetParser {
	
	@RequestMapping(method = RequestMethod.POST, value ="/AddScreenerBSDataTOSQL")
	public void getScreenerRatio(ScreenerBalanceSheetEntity screenerBalanceSheetEntity) throws Exception {
		CompanySymbol symbol=new CompanySymbol();
		List<ScreenerBalanceSheetEntity> lst=	getScreenerBSService(symbol.getCompnyList());
		/*
		 * for (ScreenerBalanceSheetEntity BSentity : lst){ //
		 * screenerDataService.save(stockRatioEntity1); }
		*/ 
	}

}
