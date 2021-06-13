package com.webscraping.stockdata.service;

import java.util.List;

import com.webscraping.stockdata.entity.ScreenerRatioEntity;
import com.webscraping.stockdata.repository.ScreenerRatioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ScreenerDataServiceImpl implements ScreenerDataService {

	@Autowired
	ScreenerRatioRepository screenerRatioRepository;
	@Override
	public List<ScreenerRatioEntity> findAll() {
		return screenerRatioRepository.findAll();
	}

	@Override
	public ScreenerRatioEntity save(ScreenerRatioEntity screenerRatioEntity) {
		screenerRatioRepository.save(screenerRatioEntity);
		return screenerRatioEntity;
	}

	@Override
	public ScreenerRatioEntity findById(Long id) {
		if(screenerRatioRepository.findById(id).isPresent())
		{
			return screenerRatioRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		ScreenerRatioEntity screenerRatioEntity=findById(id);
	screenerRatioRepository.delete(screenerRatioEntity);
	}

}
