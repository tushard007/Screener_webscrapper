package com.webscraping.stockdata.service;

import java.util.List;

import com.webscraping.stockdata.entity.ScreenerBalanceSheetEntity;

public interface ScreenerBalanceSheetService {
	  List<ScreenerBalanceSheetEntity> findAll();
	  ScreenerBalanceSheetEntity save(ScreenerBalanceSheetEntity screenerBalanceSheetEntity);
	  ScreenerBalanceSheetEntity findById(Long id);
	  void delete(Long id);
}
