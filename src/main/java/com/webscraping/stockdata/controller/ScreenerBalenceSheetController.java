package com.webscraping.stockdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webscraping.stockdata.common.CompanySymbol;
import com.webscraping.stockdata.entity.ScreenerBalanceSheetEntity;
import com.webscraping.stockdata.selenium.ScreenerBalenceSheetParser;
import com.webscraping.stockdata.service.ScreenerBalanceSheetService;

@Controller
@RequestMapping("/webscraping-selenium-app")
public class ScreenerBalenceSheetController extends ScreenerBalenceSheetParser {
	@Autowired
	ScreenerBalanceSheetService screenerBalanceSheetService;
	
	@RequestMapping(method = RequestMethod.POST, value ="/AddScreenerBSDataTOSQL")
	public void getScreenerRatio(ScreenerBalanceSheetEntity screenerBalanceSheetEntity) throws Exception {
		CompanySymbol symbol=new CompanySymbol();
		List<ScreenerBalanceSheetEntity> lst=	getScreenerBSService(symbol.getCompnyList());
	
		//screenerBalanceSheetEntity.setCompanyName("Reliance")
		for (ScreenerBalanceSheetEntity BSentity : lst){ 
			BSentity.setCompanyName(BSentity.getCompanyName());
			BSentity.setQuater(BSentity.getQuater());
			BSentity.setQuaterlySales(BSentity.getQuaterlySales());
			screenerBalanceSheetService.save(BSentity); 
		}

	}

}
