package com.webscraping.stockdata.controller;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webscraping.stockdata.common.CompanySymbol;
import com.webscraping.stockdata.entity.ScreenerRatioEntity;
import com.webscraping.stockdata.selenium.ScreenerRatioParser;
import com.webscraping.stockdata.service.ScreenerDataService;

@CrossOrigin
@RestController
@RequestMapping("/webscraping-selenium-app")
public class ScreenerRatioController extends ScreenerRatioParser {

	@Autowired
	ScreenerDataService screenerDataService;


	@RequestMapping(method = RequestMethod.POST, value ="/AddScreenerDataTOCSV")
	public void addScreenerRatio(ScreenerRatioEntity screenerRatioEntity) throws Exception {
		Writer writer = new FileWriter("E://stock market data//Screener.csv");
		/*
		 * final ColumnPositionMappingStrategy<ScreenerRatioEntity> mappingStrategy =
		 * new ColumnPositionMappingStrategy<>();
		 * mappingStrategy.setType(ScreenerRatioEntity.class);
		 * StatefulBeanToCsv<ScreenerRatioEntity> beanToCsv = new
		 * StatefulBeanToCsvBuilder<ScreenerRatioEntity>(writer) .build();
		 */
		CompanySymbol symbol=new CompanySymbol();
		ArrayList<ScreenerRatioEntity> lst=	getScreenerRatioService(symbol.getCompnyList());
		for (ScreenerRatioEntity stockRatioEntity1 : lst){
			System.out.println("______From Controller_______"+stockRatioEntity1);
			//screenerService.addScreenerRatio(stockRatioEntity1);
		}
			//beanToCsv.write(lst);
		writer.close();
	}

	@RequestMapping(method = RequestMethod.POST, value ="/AddScreenerDataTOSQL")
	public void getScreenerRatio(ScreenerRatioEntity screenerRatioEntity) throws Exception {
		CompanySymbol symbol=new CompanySymbol();
		List<ScreenerRatioEntity> lst=	getScreenerRatioService(symbol.getCompnyList());
		for (ScreenerRatioEntity stockRatioEntity1 : lst){
			screenerDataService.save(stockRatioEntity1);
		}
	}
	
	@RequestMapping("/GetScreenerData/{id}")
	public void getScreenerRatioId(@PathVariable int id) {
		//return screenerService.getScreenerRatioBYId(id);
	}

}

